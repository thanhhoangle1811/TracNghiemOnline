package demo.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo.entities.Account;
import demo.entities.AccountExam;
import demo.entities.AccountRole;

@Repository("accountExamDAO")
public class AccountExamDAOImpl implements AccountExamDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int create(AccountExam accountExam) {
		int result =0;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			result = (int) session.save(accountExam);
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
