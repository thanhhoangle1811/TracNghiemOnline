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
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import demo.dao.QuestionDAO;
import demo.dto.ExamDTO;
import demo.dto.ResultDTO;
import demo.dto.ResultDTOs;
import demo.entities.*;
import demo.services.*;

@SuppressWarnings("unused")
@Controller
@RequestMapping("exam")
public class ExamController {
	@Autowired
	private ExamService examService;
	@Autowired
	private QuestionTypeService questionTypeService;
	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = { "/edit.html" }, method = RequestMethod.GET)
	public String edit(@RequestParam("questionid") int questionId, ModelMap modelMap) {
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
	    List<Exam> exams =  filterExam(question.getExams());
        question.setExams(exams);
		boolean flag = questionService.updateQuestion(question);
		if (flag == true) {
			return "exam.create";
		} else {
			return "demo.index";
		}

	}

	@RequestMapping(value = { "/create.html" }, method = RequestMethod.GET)
	public String create(ModelMap modelMap) {
		List<Exam> exams = examService.findAll();
		List<Questiontype> questiontypes = questionTypeService.findAll();
		modelMap.put("questionTypes", questiontypes);
		modelMap.put("exams", exams);
		return "exam.create";
	}

	@RequestMapping(value = { "/create.html" }, method = RequestMethod.POST)
	public String createQuestion(@ModelAttribute("question") Question question, ModelMap modelMap) {
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
		Exam exam = examService.findById(examId);
		Date date = exam.getTime();
		DateFormat formatter = new SimpleDateFormat("mm:ss");

		String time = formatter.format(date);

		List<Question> list = filterQuestion(exam);
		modelMap.put("questions", list);
		modelMap.put("exam", exam);
		modelMap.put("time", time);
		modelMap.put("accountId", 1);
		return "exam.showexam";
	}

	private List<Question> filterQuestion(Exam exam) {
		List<Question> list = exam.getQuestions();
		Collections.shuffle(list);
		if (list.size() > 20) {
			list = list.subList(0, 20);
		}
		return list;
	}

	@RequestMapping(value = { "/showexam.html" }, method = RequestMethod.POST)
	public String showexam(@ModelAttribute("examDto") ExamDTO examDTO, ModelMap modelMap) {
		String examName = examDTO.getExam().getName();
		List<ResultDTO> resultDTOs = examDTO.getResultDTOs();
		int totalQuestion = 0;
		int totalRightAnswer = 0;
		float totalGradeOfExam = 0;
		float totalGradeOfUser = 0;
		for (int i = 0; i < resultDTOs.size(); i++) {
			String isTrue = resultDTOs.get(i).getIsTrue();
			if (isTrue != null && (isTrue.equalsIgnoreCase("true") || isTrue.equalsIgnoreCase("on"))) {
				Question currentQuestion = questionService.findById(resultDTOs.get(i).getResult().getQuestion().getId());
				totalGradeOfExam += currentQuestion.getGrade();
				totalQuestion += 1;
				if (currentQuestion.getQuestiontype().getId() == 1) {
					Answer rightAnswer = null;
					List<Answer> answers = currentQuestion.getAnswers();
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
		}		
		
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
	/* Ca le */
}
