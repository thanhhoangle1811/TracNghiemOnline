package demo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.CategoryDAO;
import demo.entities.*;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl 
	implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	public List<Category> findAll() {
		return categoryDAO.findAll();
	}
	
	@Override
    public Category findById(int id) {
        // TODO Auto-generated method stub
        return categoryDAO.findById(id);
    }
	
	@Override
	public boolean createCategory(Category category) {
		return categoryDAO.createCategory(category);
	}
	
	@Override
	public boolean updateCategory(Category category) {
		return categoryDAO.updateCategory(category);
	}

}
