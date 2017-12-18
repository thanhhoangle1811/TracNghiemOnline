package demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import demo.entities.Category;
import demo.entities.Exam;
import demo.services.*;

@Controller
@RequestMapping("general")
public class GeneralController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "redirect:general.login";
	}

	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			ModelMap modelMap) {
		if (error != null) {
			modelMap.addAttribute("msg",
					"Invalid username and password! Do you have account?");
		}
		if (logout != null) {
			modelMap.addAttribute("msg", "You've been logged out successfully.");
		}
		return "general.login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "general.login";
	}

	/*
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accesssDenied(ModelMap modelMap) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			modelMap.addAttribute("username", userDetail.getUsername());
		}
		return "403";
	}
	*/
}
