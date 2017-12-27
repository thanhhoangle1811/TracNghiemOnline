package demo.dto;

import demo.entities.*;
import java.util.*;

public class ExamDTO {
    private Exam exam;
    private List<ResultDTO> resultDTOs;
    
    
    
    
    
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
