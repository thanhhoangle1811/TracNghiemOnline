package demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.entities.Answer;
@Repository("answerDAO")
public class AnswerDAOImpl implements AnswerDAO{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public int storeAnswer(Answer answer) {
        // TODO Auto-generated method stub
        int result = 0;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            //int questionId = (int) session.save(question);
            result = (int) session.save(answer);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }

}
