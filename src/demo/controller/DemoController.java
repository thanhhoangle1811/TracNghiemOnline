package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import demo.entities.Account;
import demo.services.*;

@Controller
@RequestMapping("demo")
public class DemoController {

	@Autowired
    private AccountService accountService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
//	    List<Question> questions = questionService.findQuestionByExamid(1);
/*	    AccountRole accountRole = new AccountRole();
	    Role role = new Role();
	    role.setId(2);
	    Account account = new Account();
	    account.setId(1);
	    accountRole.setEnable(true);
	    accountRole.setAccount(account);
	    accountRole.setRole(role);
	    accountService.setAccountRole(accountRole);*/
	    /*Account account = accountService.getAccountById(1);*/
		return "demo.index";
	}
	
	
}
