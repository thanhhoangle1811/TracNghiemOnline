package demo.services;

import demo.entities.*;
import java.util.*;

public interface CategoryService {

	public List<Category> findAll();
	public Category findById(int id);
	public boolean createCategory(Category category);
	public boolean updateCategory(Category category);
}
