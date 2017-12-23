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
import demo.entities.AccountRole;
import demo.entities.Category;
import demo.entities.Exam;
import demo.entities.Role;
import demo.services.*;

@Controller
@RequestMapping("account")
public class AccountController {

	@Autowired
	private AccountService accountService;	
	@Autowired
	private RoleService roleService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private AccountRoleService accountRoleService;
	
	@RequestMapping(value = { "/register.html" }, method = RequestMethod.GET)
	public String register(ModelMap modelMap) {
		modelMap.put("account", new Account());
		modelMap.put("roles", roleService.findAll());
		return "account.register";
	}
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(
			@ModelAttribute("account") Account account, 
			HttpServletRequest request) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		account.setEnabled(true);
		//List<Role> roles = new ArrayList<Role>();
		Account newAccount = accountService.create(account);
		Role newRole = roleService.find(2);
		AccountRole accountRole = new AccountRole();
		accountRole.setEnable(true);
		accountRole.setAccount(newAccount);
		accountRole.setRole(newRole);
		accountRoleService.create(accountRole);
		return "redirect:../category/index.html";
	}
}
