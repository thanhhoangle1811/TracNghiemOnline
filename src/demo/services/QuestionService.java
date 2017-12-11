package demo.services;

import java.util.List;

import demo.entities.Category;
import demo.entities.Question;

public interface QuestionService {
	public List<Question> findByExamId(int examId);
	public boolean createQuestion(Question question);

    public boolean updateListQuestion(List<Question> questions);
}
