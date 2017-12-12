package demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import demo.entities.Category;
import demo.entities.Exam;
import demo.services.*;

@Controller
@RequestMapping("category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = { "/index.html" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("categories", 
				categoryService.findAll());
		return "category.index";
	}

	@RequestMapping(value = { "/examsbycategory" }, params = { "id" }, method = RequestMethod.GET)
	public String examsbycategory(@RequestParam(value = "id") int id, ModelMap modelMap) {

		Category category =  categoryService.findById(id);
		List<Exam> list = new ArrayList<Exam>(category.getExams());
		modelMap.put("exams", list);
		return "category.examsbycategory";
	}
	
	
}
