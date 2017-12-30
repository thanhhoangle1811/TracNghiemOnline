package demo.dto;

import java.util.*;

public class ExamOfUserDTO {
    private int examid;
    private String examName;
    private float totalMark;
    private float mark;
    private Date time;
    
    public int getExamid() {
        return examid;
    }
    public void setExamid(int examid) {
        this.examid = examid;
    }
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	
	public float getTotalMark() {
		return totalMark;
	}
	public void setTotalMark(float totalMark) {
		this.totalMark = totalMark;
	}
	
	public float getMark() {
		return mark;
	}
	public void setMark(float mark) {
		this.mark = mark;
	}
    
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
    
}
