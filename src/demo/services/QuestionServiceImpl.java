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
    public boolean updateListQuestion(List<Question> questions) {
	    boolean result = false;
        // TODO Auto-generated method stub
	    for (Question question : questions) {
	        result = questionDAO.updateQuestion(question);
	        if(result == false) {
	            break;
	        }
        }
        return result;
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
