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
import demo.entities.Answer;
import demo.entities.Category;
import demo.entities.Exam;
import demo.entities.Question;
import demo.entities.Result;
import demo.entities.Role;
import demo.services.*;
import demo.dto.AccountExamDTO;;

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
	@Autowired
	private ResultService resultService;
	@Autowired
    private ExamService examService;
	@Autowired
    private QuestionService questionService;
	
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
	
	@RequestMapping(value = { "/myQuiz" }, params = { "id" }, method = RequestMethod.GET)
	public String myQuizHistory(@RequestParam(value = "id") int id, ModelMap modelMap) {
		List<Result> resultsCheck = resultService.findAll();
		List<Result> results = resultService.findAllResultOfUser(id);
		List<AccountExamDTO> quizes = new ArrayList<AccountExamDTO>();
		//find all exam the user has been done
		int examId = -1;
		for(int i = 0; i < results.size(); i++){
			if(examId != results.get(i).getExam().getId()){
				examId = results.get(i).getExam().getId();
				AccountExamDTO quiz = new AccountExamDTO();
				quiz.setExamId(examId);
				quiz.setExamName(results.get(i).getExam().getName());
				quiz.setMark(0);
				quiz.setTotalMark(0);
				quizes.add(quiz);
			}
		}
		//find the grade the user has achieve in each quiz
		for(int i = 0; i < quizes.size(); i++){
			//List<Question> questionList = examService.findQuestionsById(quizes.get(i).getExamId());
			List<Result> examResults = resultService.findExamResultOfUser(results, quizes.get(i).getExamId());
			
			/*
			//by question
			for(int j = 0; j < questionList.size(); j++){
	    		Question currentQuestion = questionList.get(j);
	    		quizes.get(i).setTotalMark(quizes.get(i).getTotalMark() + currentQuestion.getGrade());	    		
	    		Result currentResult = resultService.getResultByQuestionId(examResults, currentQuestion.getId());
	    		if(currentQuestion.getQuestiontype().getId() == 1){
	    			Answer rightAnswer = null;
	    			List<Answer> answers =  currentQuestion.getAnswers();
	    			for(int k = 0; k < answers.size(); k++){
	    				if(answers.get(k).isIstrue()){
	    					rightAnswer = answers.get(k);
	    				}
	    			}
	    			if(rightAnswer != null && rightAnswer.getId() == currentResult.getAnswer().getId()){
	    				quizes.get(i).setMark(quizes.get(i).getMark() + currentQuestion.getGrade());
	    			}
	    		}
	    		else{
	    			
	    		}
	    	}
	    	*/
			
			//by result
			for(int j = 0; j < examResults.size(); j++){
				Result currentResult = examResults.get(j);
	    		Question currentQuestion = questionService.findById(currentResult.getQuestion().getId());
	    		quizes.get(i).setTotalMark(quizes.get(i).getTotalMark() + currentQuestion.getGrade());
	    		if(currentQuestion.getQuestiontype().getId() == 1){
	    			Answer rightAnswer = null;
	    			List<Answer> answers =  currentQuestion.getAnswers();
	    			if(answers != null && answers.size() > 0 && answers.get(0).getId() == currentResult.getAnswer().getId()){
	    				quizes.get(i).setMark(quizes.get(i).getMark() + currentQuestion.getGrade());
	    			}
	    		}
	    		else{
	    			/*
	    			Answer rightAnswer = null;
	    			List<Answer> answers =  currentQuestion.getAnswers();
	    			for(int k = 0; k < answers.size(); k++){
	    				if(answers.get(k).isIstrue()){
	    					rightAnswer = answers.get(k);
	    				}
	    			}
	    			if(rightAnswer != null && rightAnswer.getId() == currentResult.getAnswer().getId()){
	    				
	    			}
	    			*/
	    		}
	    	}
		}
		
		modelMap.put("quizes", quizes);
		return "account.myquizhistory";
	}
}
