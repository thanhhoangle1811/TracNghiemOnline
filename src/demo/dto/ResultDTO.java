package demo.dto;

import demo.entities.Result;

public class ResultDTO {
	private Result result;
	String isTrue;
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public String getIsTrue() {
		return isTrue;
	}
	public void setIsTrue(String isTrue) {
		this.isTrue = isTrue;
	}
	public ResultDTO(Result result, String isTrue) {
		super();
		this.result = result;
		this.isTrue = isTrue;
	}
	public ResultDTO() {
		super();
	}
	
}
