package demo.dao;

import demo.entities.*;
import java.util.*;

public interface CategoryDAO {
	
	public List<Category> findAll();
	public Category findById(int id);
	public boolean createCategory(Category category);
	public boolean updateCategory(Category category);
}
