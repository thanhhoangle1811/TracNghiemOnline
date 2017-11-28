package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import demo.services.*;

@Controller
@RequestMapping("demo")
public class DemoController {


	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		
		return "index";
	}
	
	
}
