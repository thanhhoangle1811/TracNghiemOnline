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

import com.sun.swing.internal.plaf.basic.resources.basic;

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
	public String edit(@RequestParam("questionid") int questionId,  ModelMap modelMap) {
		Question question = questionService.findById(questionId);
		
		modelMap.put("question", question);
		return "exam.edit";
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = { "/edit.html" }, method = RequestMethod.POST)
    public String edit(@ModelAttribute("question") Question question,ModelMap modelMap) {
        boolean flag = questionService.updateQuestion(question);
        if(flag == true){
            return "exam.create";
        }else{
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
	public String createQuestion(@ModelAttribute("question") Question question,ModelMap modelMap) {
		boolean flag = questionService.createQuestion(question);
		if(flag){
			return "exam.create";
		}else{
			return "demo.index";
		}
		
	}
	/*Ca le*/
	
	@RequestMapping(value = { "/showexam.html" }, params = { "id" }, method = RequestMethod.GET)
	public String showexam(@RequestParam(value = "id") int id, ModelMap modelMap) {
		Exam exam =  examService.findById(id);
		List<Question> list = new ArrayList<Question>(exam.getQuestions());
		modelMap.put("questions", list);
		return "exam.showexam";
	}
	
	@RequestMapping(value = { "/showexam.html" }, method = RequestMethod.POST)
	public String showexam(@ModelAttribute("exam") Exam exam,ModelMap modelMap) {
		/*boolean flag = questionService.createQuestion(question);
		if(flag){
			return "exam.create";
		}else{
			return "demo.index";
		}*/
		return "exam.create";
	}
	
	
	
	/*Ca le*/
}
