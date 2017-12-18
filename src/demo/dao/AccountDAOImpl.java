package demo.dao;

import java.util.*;
import demo.entities.*;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Repository("accountDAO")
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Account create(Account account) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(account);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return account;
	}
	
}
