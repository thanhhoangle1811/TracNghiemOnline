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
        Question question = questionService.findById(questionId);

        modelMap.put("question", question);
        return "exam.edit";
    }

    @RequestMapping(value = { "/edit.html" }, method = RequestMethod.POST)
    public String edit(@ModelAttribute("question") Question question, ModelMap modelMap) {
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
        boolean flag = questionService.createQuestion(question);
        if (flag) {
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
        
        String time =formatter.format(date); 
        
        List<Question> list = filterQuestion(exam);
        modelMap.put("questions", list);
        modelMap.put("exam", exam);
        modelMap.put("time", time);
        modelMap.put("accountId", 1);
        return "exam.showexam";
    }
    private List<Question> filterQuestion(Exam exam){
        List<Question> list =exam.getQuestions();
        /*for (int i = 0;i < list.size();i++) {
            List<Answer> ansTemp = new ArrayList<Answer>();
            for (Answer answer : list.get(i).getAnswers()) {
            	ansTemp.add(answer);
            }
            list.get(i).setAnswers(ansTemp);
        }*/
        Collections.shuffle(list);
        return list;
    }
    @RequestMapping(value = { "/showexam.html" }, method = RequestMethod.POST)
    public String showexam(@ModelAttribute("examDto") ExamDTO examDTO, ModelMap modelMap) {
    	 questionService.storeAnswerStu(examDTO);  
       /*
    	//find exam
    	String examName = examDTO.getExam().getName();
    	//find how many question, how many right answers
    	List<Question> questionList = examDTO.getExam().getQuestions();
    	ResultDTOs resultList =  new ResultDTOs(examDTO.getResultDTOs());
    	int totalQuestion = questionList.size();
    	int totalRightAnswer = 0;
    	float totalGradeOfExam = 0;
    	float totalGradeOfUser = 0;
    	for(int i = 0; i < totalQuestion; i++){
    		Question currentQuestion = questionList.get(i);
    		totalGradeOfExam += currentQuestion.getGrade();
    		Result currentResult = resultList.getResultByQuestionId(currentQuestion.getId());
    		if(currentQuestion.getQuestiontype().getId() == 1){
    			List<Answer> rightAnswers =  currentQuestion.getAnswers();
    			if(rightAnswers.size() == 1 && rightAnswers.get(0).getId() == currentResult.getAnswer().getId()){
    				totalRightAnswer++;
    				totalGradeOfUser += currentQuestion.getGrade();
    			}
    		}
    		else{
    			
    		}
    		modelMap.put("examName", examName);
            modelMap.put("totalQuestion", totalQuestion);
            modelMap.put("totalRightAnswer", totalRightAnswer);
            modelMap.put("totalGradeOfExam", totalGradeOfExam);
            modelMap.put("totalGradeOfUser", totalGradeOfUser);
            return "exam.showexamresult";
    	}
    	//find total grade for the exam
    	//find total grade user achieve, percentage
    	//find the time user used
    	*/
    	String examName = examDTO.getExam().getName();
    	List<Question> questionList = examService.findQuestionsById(examDTO.getExam().getId());
    	ResultDTOs resultList =  new ResultDTOs(examDTO.getResultDTOs());
    	int totalQuestion = questionList.size();
    	int totalRightAnswer = 0;
    	float totalGradeOfExam = 0;
    	float totalGradeOfUser = 0;
    	for(int i = 0; i < totalQuestion; i++){
    		Question currentQuestion = questionList.get(i);
    		totalGradeOfExam += currentQuestion.getGrade();
    		
    		Result currentResult = resultList.getResultByQuestionId(currentQuestion.getId());
    		if(currentQuestion.getQuestiontype().getId() == 1){
    			Answer rightAnswer = null;
    			List<Answer> answers =  currentQuestion.getAnswers();
    			for(int j = 0; j < answers.size(); j++){
    				if(answers.get(j).isIstrue()){
    					rightAnswer = answers.get(j);
    				}
    			}
    			if(rightAnswer != null && rightAnswer.getId() == currentResult.getAnswer().getId()){
    				totalRightAnswer++;
    				totalGradeOfUser += currentQuestion.getGrade();
    			}
    		}
    		else{
    			
    		}
    	}

		modelMap.put("examName", examName);
        modelMap.put("totalQuestion", totalQuestion);
        modelMap.put("totalRightAnswer", totalRightAnswer);
        modelMap.put("totalGradeOfExam", totalGradeOfExam);
        modelMap.put("totalGradeOfUser", totalGradeOfUser);
        return "exam.showexamresult";
        
        /*if(examDTO.isComplete()) {*/
        //     
        /*}else {
            return "demo.index";
        }*/
        //return "exam.showexamresult";
    }
    
    

    /* Ca le */
}
