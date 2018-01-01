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

import demo.dto.ExamOfUserDTO;
import demo.entities.Account;
import demo.entities.AccountExam;
import demo.services.*;

@Controller
@RequestMapping("account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = { "/myquizhistory" }, method = RequestMethod.GET)
	public String myQuizHistory(ModelMap modelMap) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			Account account = accountService.getAccountByEmail(userDetail.getUsername());
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
		
		return "general.403";
	}
	
	@RequestMapping(value = { "/userquizhistory" }, params = { "id" }, method = RequestMethod.GET)
	public String userQuizHistory(@RequestParam(value = "id") int id, ModelMap modelMap) {
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
	
	@RequestMapping(value = { "/allaccounts" }, method = RequestMethod.GET)
	public String getAllAccounts(ModelMap modelMap) {
		List<Account> accounts = accountService.getAll();
		modelMap.put("accounts", accounts);
		return "account.allaccounts";
	}
}
