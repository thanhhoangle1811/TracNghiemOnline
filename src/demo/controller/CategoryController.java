package demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import demo.entities.Category;
import demo.entities.Exam;
import demo.entities.Question;
import demo.entities.Questiontype;
import demo.services.*;

@Controller
@RequestMapping("category")
public class CategoryController extends CommonController{

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = { "/index.html" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		this.setCommon(modelMap,"result-label");
		modelMap.put("categories", 
				categoryService.findAll());
		return "category.index";
	}

	@RequestMapping(value = { "/examsbycategory" }, params = { "id" }, method = RequestMethod.GET)
	public String examsbycategory(@RequestParam(value = "id") int id, ModelMap modelMap) {
		this.setCommon(modelMap,"category-label");
		Category category =  categoryService.findById(id);
		List<Exam> list = new ArrayList<Exam>(category.getExams());
		modelMap.put("exams", list);
		return "category.examsbycategory";
	}
	
	@RequestMapping(value = { "/create.html" }, method = RequestMethod.GET)
	public String create(ModelMap modelMap) {
		return "category.create";
	}

	@RequestMapping(value = { "/create.html" }, method = RequestMethod.POST)
	public String createCategory(@ModelAttribute("category") Category category, ModelMap modelMap) {
		boolean flag = categoryService.createCategory(category);
		String msg;
		if (flag) {
			msg = "Create new category successfully.";
		} else {
			msg = "Create new category failed, please try again.";
		}
		modelMap.put("msg", msg);
		return "category.create";
	}
	
	@RequestMapping(value = { "/edit.html" }, method = RequestMethod.GET)
	public String edit(@RequestParam("categoryid") int categoryid, ModelMap modelMap) {
		Category category = categoryService.findById(categoryid);

		modelMap.put("category", category);
		return "category.edit";
	}

	@RequestMapping(value = { "/edit.html" }, method = RequestMethod.POST)
	public String edit(@ModelAttribute("category") Category category, ModelMap modelMap) {
		boolean flag = categoryService.updateCategory(category);
		String msg;
		if (flag) {
			msg = "Edit the category successfully.";
		} else {
			msg = "Edit the category failed, please try again.";
		}
		modelMap.put("msg", msg);
		return "category.edit";
	}
	
}
