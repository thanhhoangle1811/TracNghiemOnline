package demo.dao;
import java.util.List;

import demo.entities.*;
public interface QuestionDAO {
	public List<Question> findByExam(int gradeId); 
	public boolean createQuestion(Question question);
	public boolean updateQuestion(Question questions);
	public Question findById(int questionId);
}
