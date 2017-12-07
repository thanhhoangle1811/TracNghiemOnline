package demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.CategoryDAO;
import demo.dao.QuestionDAO;
import demo.entities.Question;

@Service("questionService")
@Transactional
public class QuestionServiceImpl implements QuestionService{
	@Autowired
	private QuestionDAO questionDAO;
	@Override
	public List<Question> findByExamId(int examId) {
		// TODO Auto-generated method stub
		
		return questionDAO.findByExam(examId);
	}

}
