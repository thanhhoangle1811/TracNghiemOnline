package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import demo.entities.Question;
import demo.services.*;

@Controller
@RequestMapping("exam")
public class ExamController {
	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = { "/create.html" }, method = RequestMethod.GET)
	public String create(ModelMap modelMap) {

		List<Question> questions =  questionService.findByExamId(1);
		modelMap.put("questions", questions);
		return "exam.create";
	}

	@RequestMapping(value = { "/create.html" }, method = RequestMethod.POST)
	public String createQuestion(ModelMap modelMap) {
		return "exam.create";
	}
}
