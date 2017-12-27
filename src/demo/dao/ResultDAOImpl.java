package demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.entities.Result;
import demo.entities.Role;
@Repository("resultDAO")
public class ResultDAOImpl implements ResultDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public int storeResult(Result result) {
        int result_ = 0;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            result_ = (int) session.save(result);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result_;
    }
    
    @SuppressWarnings("unchecked")
	@Override
	public List<Result> findAll() {
		List<Result> results = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			results = session.createCriteria(Result.class).list();
			transaction.commit();
		} catch (Exception e) {
			results = null;
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return results;
	}

}
