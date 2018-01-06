package demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import demo.dao.QuestionDAO;
import demo.dto.ExamDTO;
import demo.dto.ResultDTO;
import demo.dto.ResultDTOs;
import demo.entities.*;
import demo.services.*;
import demo.dto.*;
@SuppressWarnings("unused")
@Controller
@RequestMapping("exam")
public class ExamController extends CommonController{
	@Autowired
	private ExamService examService;
	@Autowired
	private QuestionTypeService questionTypeService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private CategoryService categoryService;
	
	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
	    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");  
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));  
	}
	
	@RequestMapping(value = { "/index.html" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		this.setCommon(modelMap,"exam-label");
		modelMap.put("exams", 
				examService.findAll());
		return "exam.index";
	}
	
	@RequestMapping(value = { "/questionlist.html" }, method = RequestMethod.GET)
	public String showQuestionList(@RequestParam("examid") int examid, ModelMap modelMap) {
		this.setCommon(modelMap,"question-list-label");
		modelMap.put("questions", 
				questionService.findQuestionByExamid(examid));
		return "exam.questionlist";
	}
	
	@RequestMapping(value = { "/edit.html" }, method = RequestMethod.GET)
	public String edit(@RequestParam("questionid") int questionId, ModelMap modelMap) {
		this.setCommon(modelMap,"question-edit-label");
		List<Exam> exams = examService.findAll();
		List<Questiontype> questiontypes = questionTypeService.findAll();
		modelMap.put("questionTypes", questiontypes);
		modelMap.put("exams", exams);
		
		Question question = questionService.findById(questionId);

		modelMap.put("question", question);
		return "exam.edit";
	}

	@RequestMapping(value = { "/edit.html" }, method = RequestMethod.POST)
	public String edit(@ModelAttribute("question") Question question, ModelMap modelMap) {
		this.setCommon(modelMap,"question-edit-post-label");
	    List<Exam> exams =  filterExam(question.getExams());
        question.setExams(exams);
		boolean flag = questionService.updateQuestion(question);
		if (flag == true) {
			return "exam.create";
		} else {
			return "demo.index";
		}

	}
	@RequestMapping(value = { "/create-exam.html" }, method = RequestMethod.GET)
    public String createExam(ModelMap modelMap) {
		this.setCommon(modelMap,"exm-create-label");
	    List<Category> categories =  categoryService.findAll();
        modelMap.put("categories", categories);
        return "exam.create.exam";
    }
	
	@RequestMapping(value = { "/create-exam.html" }, method = RequestMethod.POST)
    public String createExam(@ModelAttribute("exam") Exam exam, ModelMap modelMap) {
		this.setCommon(modelMap,"exm-create-post-label");
        List<Category> categories =  categoryService.findAll();        
        modelMap.put("categories", categories);
	    examService.createExam(exam);
        return "exam.create.exam";
    }

	@RequestMapping(value = { "/create.html" }, method = RequestMethod.GET)
	public String create(ModelMap modelMap) {
		this.setCommon(modelMap,"question-create-label");
		List<Exam> exams = examService.findAll();
		List<Questiontype> questiontypes = questionTypeService.findAll();
		modelMap.put("questionTypes", questiontypes);
		modelMap.put("exams", exams);
		return "exam.create";
	}

	@RequestMapping(value = { "/create.html" }, method = RequestMethod.POST)
	public String createQuestion(@ModelAttribute("question") Question question, ModelMap modelMap) {
		this.setCommon(modelMap,"question-create-post-label");
		List<Exam> exams =  filterExam(question.getExams());
		question.setExams(exams);
		boolean flag = questionService.createQuestion(question);
		if (flag) {
			List<Exam> examsN = examService.findAll();
			List<Questiontype> questiontypes = questionTypeService.findAll();
			modelMap.put("questionTypes", questiontypes);
			modelMap.put("exams", examsN);
			return "exam.create";
		} else {
			return "demo.index";
		}

	}
	/* Ca le */

	@RequestMapping(value = { "/showexam.html" }, params = { "id" }, method = RequestMethod.GET)
	public String showexam(@RequestParam(value = "id") int examId, ModelMap modelMap) {
		this.setCommon(modelMap,"show-exam-label");
		Exam exam = examService.findById(examId);
		Date date = exam.getTime();
		DateFormat formatter = new SimpleDateFormat("mm:ss");

		String time = formatter.format(date);

		List<Question> list = filterQuestion(exam);
		modelMap.put("questions", list);
		modelMap.put("exam", exam);
		modelMap.put("time", time);
		//TODO: put value account
		modelMap.put("accountId", this.getAccountByAuthentication().getId());
		return "exam.showexam";
	}

	private List<Question> filterQuestion(Exam exam) {
		List<Question> list = exam.getQuestions();
		Collections.shuffle(list);
		if (list.size() > Consts.MAX_QUESTION) {
			list = list.subList(0, Consts.MAX_QUESTION);
		}
		return list;
	}

	@RequestMapping(value = { "/showexam.html" }, method = RequestMethod.POST)
	public String showexam(@ModelAttribute("examDto") ExamDTO examDTO, ModelMap modelMap) {
		this.setCommon(modelMap,"show-result-label");
		String examName = examDTO.getExam().getName();
		List<ResultDTO> resultDTOs = examDTO.getResultDTOs();
		List<ResultDTO> trueResultDTOs = new ArrayList<ResultDTO>();
		
		for(int i = 0; i < resultDTOs.size(); i++){
			String isTrue = resultDTOs.get(i).getIsTrue();
			if (isTrue != null && (isTrue.equalsIgnoreCase("true") || isTrue.equalsIgnoreCase("on"))){
				trueResultDTOs.add(resultDTOs.get(i));
			}
		}
		
		List<Integer> resultIds = new ArrayList<Integer>();
		for(int i = 0; i < trueResultDTOs.size(); i++){
			if(!resultIds.contains(trueResultDTOs.get(i).getResult().getQuestion().getId())){
				resultIds.add(trueResultDTOs.get(i).getResult().getQuestion().getId());
			}
		}
		
		int totalQuestion = 0;
		int totalRightAnswer = 0;
		float totalGradeOfExam = 0;
		float totalGradeOfUser = 0;
		
		for(int i = 0; i < resultIds.size(); i++){
			Question currentQuestion = questionService.findById(resultIds.get(i));
			List<ResultDTO> resultDTOsOfCurrentQuestion = new ArrayList<ResultDTO>();
			
			for(int j = 0; j < trueResultDTOs.size(); j++){
				if (trueResultDTOs.get(j).getResult().getQuestion().getId() == resultIds.get(i)){
					resultDTOsOfCurrentQuestion.add(trueResultDTOs.get(j));
				}
			}
			
			totalGradeOfExam += currentQuestion.getGrade();
			totalQuestion += 1;
			List<Answer> answers = currentQuestion.getAnswers();
			List<Answer> rightAnswersOfQuestion = new ArrayList<Answer>();
			for (int j = 0; j < answers.size(); j++) {
				if (answers.get(j).isIstrue()) {
					rightAnswersOfQuestion.add(answers.get(j));
				}
			}
			if (currentQuestion.getQuestiontype().getId() == 1) {
				Answer rightAnswer = rightAnswersOfQuestion.get(0);		
				if (rightAnswer != null 
					&& resultDTOsOfCurrentQuestion.size() == 1
					&& rightAnswer.getId() == resultDTOsOfCurrentQuestion.get(0).getResult().getAnswer().getId()) {
					totalRightAnswer++;
					totalGradeOfUser += currentQuestion.getGrade();
				}
			} else {				
				if(rightAnswersOfQuestion.size() == resultDTOsOfCurrentQuestion.size()){
					int numberOfRightAnswer = 0;
					for (int k = 0; k < rightAnswersOfQuestion.size(); k++){
						for (int l = 0; l < resultDTOsOfCurrentQuestion.size(); l++){
							if(resultDTOsOfCurrentQuestion.get(l).getResult().getAnswer().getId() == rightAnswersOfQuestion.get(k).getId()){
								numberOfRightAnswer++;
								break;
							}
						}
					}
					if(numberOfRightAnswer == rightAnswersOfQuestion.size()){
						totalRightAnswer++;
						totalGradeOfUser += currentQuestion.getGrade();
					}
				}
			}
			
		}
		
		
		/*for (int i = 0; i < resultDTOs.size(); i++) {
			String isTrue = resultDTOs.get(i).getIsTrue();
			if (isTrue != null && (isTrue.equalsIgnoreCase("true") || isTrue.equalsIgnoreCase("on"))) {
				Question currentQuestion = questionService.findById(resultDTOs.get(i).getResult().getQuestion().getId());
				totalGradeOfExam += currentQuestion.getGrade();
				totalQuestion += 1;
				List<Answer> answers = currentQuestion.getAnswers();
				List<Answer> rightAnswersOfQuestion = new ArrayList<Answer>();
				for (int j = 0; j < answers.size(); j++) {
					if (answers.get(j).isIstrue()) {
						rightAnswersOfQuestion.add(answers.get(j));
					}
				}
				if (currentQuestion.getQuestiontype().getId() == 1) {
					Answer rightAnswer = rightAnswersOfQuestion.get(0);					
					for (int j = 0; j < answers.size(); j++) {
						if (answers.get(j).isIstrue()) {
							rightAnswer = answers.get(j);
							break;
						}
					}
					if (rightAnswer != null && rightAnswer.getId() == resultDTOs.get(i).getResult().getAnswer().getId()) {
						totalRightAnswer++;
						totalGradeOfUser += currentQuestion.getGrade();
					}
				} else {
					//TODO: check case questionType = 2
				}
			}			
		}*/		
		
		questionService.storeAnswerStu(examDTO, totalGradeOfUser,totalGradeOfExam);
		modelMap.put("examName", examName);
		modelMap.put("totalQuestion", totalQuestion);
		modelMap.put("totalRightAnswer", totalRightAnswer);
		modelMap.put("totalGradeOfExam", totalGradeOfExam);
		modelMap.put("totalGradeOfUser", totalGradeOfUser);
		return "exam.showexamresult";
	}

	private List<Exam> filterExam(List<Exam> exams){
		List<Exam> result = new ArrayList<Exam>();
		for (Exam exam : exams) {
			if(exam.getId() != null){
				result.add(exam);
			}
		}
		return result;
	}
}
