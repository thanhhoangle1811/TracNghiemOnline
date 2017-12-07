package demo.services;

import java.util.List;

import demo.entities.Category;
import demo.entities.Question;

public interface QuestionService {
	public List<Question> findByExamId(int examId);
}
