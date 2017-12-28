package demo.services;

import demo.entities.*;
import java.util.*;

public interface ResultService {

	public List<Result> findAllResultOfUser(int userId);
	public List<Result> findExamResultOfUser(List<Result> resultsOfUser, int examId);
	public Result getResultByQuestionId(List<Result> results, int questionId);
	public List<Result> findAll();
	
}
