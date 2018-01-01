package demo.controller;

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
import demo.entities.Role;
import demo.services.AccountRoleService;
import demo.services.AccountService;
import demo.services.RoleService;

@Controller
@RequestMapping("general")
public class GeneralController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private AccountRoleService accountRoleService;
	
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
	
	@RequestMapping(value = { "/register.html" }, method = RequestMethod.GET)
	public String register(ModelMap modelMap) {
		modelMap.put("account", new Account());
		modelMap.put("roles", roleService.findAll());
		return "general.register";
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

	@RequestMapping(value = "403", method = RequestMethod.GET)
	public String accesssDenied(ModelMap modelMap) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			modelMap.addAttribute("username", userDetail.getUsername());
		}
		return "general.403";
	}
}
