package demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import demo.dao.QuestionDAO;
import demo.entities.*;
import demo.services.*;

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
	public String edit(@RequestParam("examid") int examId,  ModelMap modelMap) {
		Exam exam = examService.findById(examId);
		List<Question> questions = exam.getQuestions();
		modelMap.put("questions", questions);
		return "exam.edit";
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
	public String createQuestion(@ModelAttribute("question") Question question,ModelMap modelMap) {
		boolean flag = questionService.createQuestion(question);
		if(flag= true){
			return "exam.create";
		}else{
			return "demo.index";
		}
		
	}
}
