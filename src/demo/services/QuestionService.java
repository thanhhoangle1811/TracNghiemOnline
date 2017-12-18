package demo.services;

import java.util.List;

import demo.dto.ExamDTO;
import demo.entities.Category;
import demo.entities.Question;

public interface QuestionService {
	public List<Question> findByExamId(int examId);
	public boolean createQuestion(Question question);

    public boolean updateQuestion(Question question);

	public Question findById(int questionId);
	public List<Question> findQuestionByExamid(int examId);
	public void storeAnswerStu(ExamDTO dto);
}
