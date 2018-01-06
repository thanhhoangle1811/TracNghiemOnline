package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;

import demo.entities.Account;
import demo.services.AccountService;
import demo.services.CategoryService;

public class CommonController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private CategoryService categoryService;

	protected Account getAccountByAuthentication(){
		Account account = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			account = accountService.getAccountByEmail(userDetail.getUsername());
		}
		return account;
	}
	
	public void setCommon(ModelMap modelMap) {
		Account account = getAccountByAuthentication();
		modelMap.put("categories", 
				categoryService.findAll());
		modelMap.put("accoutInfo", account);
	}

	public void setCommon(ModelMap modelMap, String label) {
		Account account = getAccountByAuthentication();
		modelMap.put("categories", 
				categoryService.findAll());
		modelMap.put("accoutInfo", account);
		if (label != null) {
			modelMap.put("label", label);
		}
	}
}
