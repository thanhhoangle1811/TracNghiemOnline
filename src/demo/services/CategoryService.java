package demo.services;

import demo.entities.*;
import java.util.*;

public interface CategoryService {

	public List<Category> findAll();
	public Category findById(int id);
	
}
