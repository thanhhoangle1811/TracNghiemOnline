package demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import demo.entities.Account;
import demo.entities.Category;
import demo.entities.Exam;
import demo.services.*;

@Controller
@RequestMapping("general")
public class AccountController {

	@Autowired
	private AccountService accountService;	
	@Autowired
	private RoleService roleService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private AccountRoleService accountRoleService;
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(ModelMap modelMap) {
		modelMap.put("account", new Account());
		modelMap.put("roles", roleService.findAll());
		return "user/register";
	}
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(
			@ModelAttribute("account") Account account, 
			HttpServletRequest request) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		Account newAccount = accountService.create(account);
		String []rolesId = request.getParameterValues("roles");
		if(rolesId != null && rolesId.length != 0) {
			for(String id : rolesId) {
				AccountRole accountRole = new AccountRole();
				accountRole.setEnable(true);
				accountRole.setId(new UserRoleId(
						newAccount.getId(), Integer.parseInt(id)));
				accountRoleService.create(accountRole);
			}
		}
		return "redirect:../main.html";
	}
}
