package demo.dao;

import java.util.*;
import demo.entities.*;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Repository("accountRoleDAO")
public class AccountRoleDAOImpl implements AccountRoleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(AccountRole accountRole) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(accountRole);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}
	
}
