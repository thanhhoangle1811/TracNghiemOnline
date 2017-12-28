package demo.services;

import demo.dao.ResultDAO;
import demo.dao.RoleDAO;
import demo.entities.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("resultService")
@Transactional
public class ResultServiceImpl 
implements ResultService {

	@Autowired
	private ResultDAO resultDAO;
	
	@Override
	public List<Result> findAll() {
		return resultDAO.findAll();
	}
	
	@Override
	public List<Result> findAllResultOfUser(int userId) {
		List<Result> results = resultDAO.findAll();
		List<Result> resultsOfUser = new ArrayList<Result>();
		for(int i = 0; i < results.size(); i++){
			if(results.get(i).getAccount().getId() == userId){
				resultsOfUser.add(results.get(i));
			}
		}
		return resultsOfUser;
	}
	
	@Override
	public List<Result> findExamResultOfUser(List<Result> resultsOfUser, int examId) {
		List<Result> examResults = new ArrayList<Result>();
		for(int i = 0; i < examResults.size(); i++){
			if(resultsOfUser.get(i).getExam().getId() == examId){
				examResults.add(resultsOfUser.get(i));
			}
		}
		return examResults;
	}
	
	@Override
	public Result getResultByQuestionId(List<Result> results, int questionId) {
		for(int i = 0; i < results.size(); i++){
			if(results.get(i).getQuestion().getId() == questionId){
				return results.get(i);
			}
		}
		return null;
	}

}
