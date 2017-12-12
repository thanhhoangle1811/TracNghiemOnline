package demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.CategoryDAO;
import demo.dao.QuestionDAO;
import demo.entities.Exam;
import demo.entities.Question;
import demo.entities.Questiontype;

@Service("questionService")
@Transactional
public class QuestionServiceImpl implements QuestionService{
	@Autowired
	private QuestionDAO questionDAO;
	
	@Override
	public Question findById(int questionId){
		return questionDAO.findById(questionId);
	}

	@Override
    public boolean updateQuestion(Question question) {
	    return  questionDAO.updateQuestion(question);
    }
    @Override
	public List<Question> findByExamId(int examId) {
		// TODO Auto-generated method stub
		
		return questionDAO.findByExam(examId);
	}
	@Override
	public boolean createQuestion(Question question) {
		return questionDAO.createQuestion(question);
	}

}
