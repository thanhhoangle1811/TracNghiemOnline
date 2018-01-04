package demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.CategoryDAO;
import demo.dao.ExamDAO;
import demo.entities.Exam;
import demo.entities.Question;
@Service("examService")
@Transactional
public class ExamServiceImpl implements ExamService{
    @Autowired
    private ExamDAO examDAO;
    @Override
    public Exam findById(int id) {
        return examDAO.findById(id);
    }
    @Override
    public List<Exam> findAll(){
    	return examDAO.findAll();
    }
    @Override
    public List<Question> findQuestionsById(int id) {
        return examDAO.findQuestionsById(id);
    }
    @Override
    public void createExam(Exam exam) {
        examDAO.createExam(exam);
    }
}
