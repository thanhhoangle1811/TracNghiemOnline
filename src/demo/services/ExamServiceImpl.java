package demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.CategoryDAO;
import demo.dao.ExamDAO;
import demo.entities.Exam;
@Service("examService")
@Transactional
public class ExamServiceImpl implements ExamService{
    @Autowired
    private ExamDAO examDAO;
    @Override
    public Exam findById(int id) {
        // TODO Auto-generated method stub
        return examDAO.findById(id);
    }

}
