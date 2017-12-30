package demo.services;

import demo.dao.ResultDAO;
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
	public Result getResultByQuestionId(List<Result> results, int questionId) {
		for(int i = 0; i < results.size(); i++){
			if(results.get(i).getQuestion().getId() == questionId){
				return results.get(i);
			}
		}
		return null;
	}

}
