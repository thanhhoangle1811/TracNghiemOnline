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
	
	@Override
	public List<Category> findAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from Category")
				.list();
	}

	
	
}
