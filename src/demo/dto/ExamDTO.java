package demo.dto;

import demo.entities.*;
import java.util.*;

public class ExamDTO {
    private Exam exam;
    private List<ResultDTO> resultDTOs;
    private List<Answer> answers;
    private Account account;
    private boolean complete;
    
    
    
    public boolean isComplete() {
        return complete;
    }
    public void setComplete(boolean complete) {
        this.complete = complete;
    }
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    public List<Answer> getAnswers() {
        return answers;
    }
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
    public Exam getExam() {
        return exam;
    }
    public void setExam(Exam exam) {
        this.exam = exam;
    }
	public List<ResultDTO> getResultDTOs() {
		return resultDTOs;
	}
	public void setResultDTOs(List<ResultDTO> resultDTOs) {
		this.resultDTOs = resultDTOs;
	}
    
    
    
}
