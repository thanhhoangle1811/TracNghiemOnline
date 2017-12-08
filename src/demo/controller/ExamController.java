package demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import demo.entities.*;
import demo.services.*;

@Controller
@RequestMapping("exam")
public class ExamController {
	@Autowired
	private ExamService examService;

	@RequestMapping(value = { "/create.html" }, method = RequestMethod.GET)
	public String create(ModelMap modelMap) {

		Exam exam =  examService.findById(1);
		List<Question> list = new ArrayList<Question>(exam.getQuestions());
//		Set<Question> questions = exam.getQuestions(); 
		modelMap.put("questions", list);
		return "exam.create";
	}

	@RequestMapping(value = { "/create.html" }, method = RequestMethod.POST)
	public String createQuestion(ModelMap modelMap) {
		return "exam.create";
	}
}
