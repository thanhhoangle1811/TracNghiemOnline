package demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import demo.dto.ExamOfUserDTO;
import demo.entities.Account;
import demo.entities.AccountExam;
import demo.entities.AccountRole;
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
	
	@RequestMapping(value = { "/myquizhistory" }, params = { "id" }, method = RequestMethod.GET)
	public String myquizhistory(@RequestParam(value = "id") int id, ModelMap modelMap) {
		Account account =  accountService.getAccountById(id);
		List<AccountExam> quizlist = account.getAccountexams();
		List<ExamOfUserDTO> quizes = new ArrayList<ExamOfUserDTO>();
		for(int i=0; i<quizlist.size(); i++){
			ExamOfUserDTO quiz = new ExamOfUserDTO();
			quiz.setExamid(quizlist.get(i).getExam().getId());
			quiz.setExamName(quizlist.get(i).getExam().getName());
			quiz.setMark(quizlist.get(i).getGrade());
			quiz.setTotalMark(quizlist.get(i).getTotalGrade());
			quiz.setTime(quizlist.get(i).getDoingDate());
			quizes.add(quiz);
		}
		
		modelMap.put("quizes", quizes);
		return "account.myquizhistory";
	}
}
