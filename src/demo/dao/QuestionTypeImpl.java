package demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.entities.Exam;
import demo.entities.Questiontype;

@Repository("questionTypeDAO")
public class QuestionTypeImpl implements QuestionTypeDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Questiontype> findAll() {
		List<Questiontype> result = new ArrayList<Questiontype>();
    	Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Questiontype");
            result = (List<Questiontype>) query.list();
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
