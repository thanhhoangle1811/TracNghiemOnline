package demo.services;

import demo.entities.*;
import java.util.*;

public interface ResultService {

	public Result getResultByQuestionId(List<Result> results, int questionId);
	public List<Result> findAll();
	
}
