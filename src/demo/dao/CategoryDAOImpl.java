package demo.dao;

import java.util.*;
import demo.entities.*;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAll() {
		List<Category> categories = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			categories = session.createQuery("from Category").list();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return categories;
	}

	@Override
    public Category findById(int id) {
        Category category = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Category c where c.id = :id");
            query.setParameter("id", id);
            category = (Category) query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return category;
    }
	
	@Override
	public boolean createCategory(Category category) {
		boolean result = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(category);
			transaction.commit();
			result = true;
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
    public boolean updateCategory(Category category) {
	    boolean result = false;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(category);
            transaction.commit();
            result = true;
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
