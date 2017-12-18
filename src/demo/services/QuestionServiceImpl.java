package demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.AnswerDAO;
import demo.dao.CategoryDAO;
import demo.dao.QuestionDAO;
import demo.dao.ResultDAO;
import demo.dto.ExamDTO;
import demo.entities.Account;
import demo.entities.Answer;
import demo.entities.Exam;
import demo.entities.Question;
import demo.entities.Questiontype;
import demo.entities.Result;

@Service("questionService")
@Transactional
public class QuestionServiceImpl implements QuestionService{
	@Autowired
	private QuestionDAO questionDAO;
	@Autowired
    private AnswerDAO answerDAO;
	@Autowired
    private ResultDAO resultDAO;
	
	
	@Override
    public void storeAnswerStu(ExamDTO dto) {
	    Result result = new Result();
	    for (Answer ans: dto.getAnswers()) {
	        int ansID = answerDAO.storeAnswer(ans);
	        if(ansID > 0) {
	            ans.setId(ansID);
	            result.setAnswer(ans);
	            result.setAccount(dto.getAccount());
	            result.setExam(dto.getExam());
	            result.setQuestion(ans.getQuestion());
	            resultDAO.storeResult(result);
	        }
        }
    }
    @Override
	public List<Question> findQuestionByExamid(int examId){
	    return questionDAO.findQuestionByExamid(examId);
	}
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
