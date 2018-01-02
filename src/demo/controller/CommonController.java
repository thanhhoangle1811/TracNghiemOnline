package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import demo.entities.Account;
import demo.services.AccountService;

public class CommonController {

	@Autowired
	private AccountService accountService;
	
	public void setCommon(ModelMap modelMap){
		Account account =  accountService.getAccountById(1);
		modelMap.put("accoutInfo",account);
	}
}
