package demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.AccountExamDAO;
import demo.dao.QuestionDAO;
import demo.dao.ResultDAO;
import demo.dto.Consts;
import demo.dto.ExamDTO;
import demo.entities.AccountExam;
import demo.entities.Question;
import demo.entities.Result;

@Service("questionService")
@Transactional
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionDAO questionDAO;
	@Autowired
	private ResultDAO resultDAO;
	@Autowired
	private AccountExamDAO accountExamDAO;
	
	@Override
	public void storeAnswerStu(ExamDTO dto,float grade,float totalGrade) {
		// set accountexam
		AccountExam accountExam = new AccountExam();
		accountExam.setAccount(dto.getAccount());
		accountExam.setExam(dto.getExam());
		accountExam.setDoingDate(new Date());
		accountExam.setTotalGrade(totalGrade);
		accountExam.setGrade(grade);
		int accountExamid =  accountExamDAO.create(accountExam);
		accountExam.setId(accountExamid);
		if(accountExamid > 0){
			List<Result> results = new ArrayList<Result>();
			for (int i = 0; i < dto.getResultDTOs().size(); i++) {
				if (dto.getResultDTOs().get(i).getIsTrue() != null
						&& (dto.getResultDTOs().get(i).getIsTrue().equalsIgnoreCase(Consts.TRUE_VALUE)
								|| dto.getResultDTOs().get(i).getIsTrue().equalsIgnoreCase(Consts.ON_VALUE))) {
					results.add(dto.getResultDTOs().get(i).getResult());
				}
			}
			for (int i = 0; i < results.size(); i++) {
				results.get(i).setAccountexam(accountExam);
				resultDAO.storeResult(results.get(i));
			}	
		}
	}

	@Override
	public List<Question> findQuestionByExamid(int examId) {
		return questionDAO.findQuestionByExamid(examId);
	}

	@Override
	public Question findById(int questionId) {
		return questionDAO.findById(questionId);
	}

	@Override
	public boolean updateQuestion(Question question) {
		return questionDAO.updateQuestion(question);
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
