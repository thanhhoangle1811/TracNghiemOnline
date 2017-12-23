package demo.dto;

import java.util.List;

import demo.entities.Result;

public class ResultDTOs {
	private List<ResultDTO> results;
	
	public Result getResultByQuestionId(int questionId) {
		for(int i = 0; i < results.size(); i++){
			if(results.get(i).getResult().getQuestion().getId() == questionId){
				return results.get(i).getResult();
			}
		}
		return null;
	}
	
	public ResultDTOs() {
		super();
	}
	
	public ResultDTOs( List<ResultDTO> resultDTOs) {
		results = resultDTOs;
	}
}
