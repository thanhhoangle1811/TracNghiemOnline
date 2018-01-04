package demo.dao;

import java.util.*;
import demo.entities.*;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Repository("roleDAO")
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAll() {
		List<Role> roles = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			roles = session.createCriteria(Role.class).list();
			transaction.commit();
		} catch (Exception e) {
			roles = null;
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return roles;
	}

	@Override
	public Role find(int id) {
		Role role = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery(" FROM Role where id = :id");
			query.setParameter("id", id);
			role = (Role) query.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			role = null;
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return role;
	}
	
}
