package demo.dao;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.entities.Exam;
import demo.entities.Question;
@Repository("examDAO")
public class ExamDAOImpl implements ExamDAO{
    @Autowired
    private SessionFactory sessionFactory;

    
    @Override
    public void createExam(Exam exam) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(exam);
            transaction.commit();
        }catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public List<Exam> findAll(){
    	List<Exam> result = new ArrayList<Exam>();
    	Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Exam");
            result = (List<Exam>) query.list();
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
    
    @Override
	public List<Question> findQuestionsById(int id) {
    	Exam exam = null;
        Session session = null;
        Transaction transaction = null;
        List<Question> questions = new ArrayList<Question>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Exam e where e.id = :id");
            query.setParameter("id", id);
            exam = (Exam) query.uniqueResult();
            questions = exam.getQuestions();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
            	transaction.rollback();
            }
        } finally {
        	
            session.close();
        }
        return questions;
	}


	@Override
    public Exam findById(int id) {
        Exam exam = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Exam e where e.id = :id");
            query.setParameter("id", id);
            exam = (Exam) query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
            	transaction.rollback();
            }
        } finally {
        	
            session.close();
        }
        return exam;
    }

}
