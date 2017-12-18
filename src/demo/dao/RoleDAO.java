package demo.dao;

import demo.entities.*;
import java.util.*;

public interface RoleDAO {
	
	public List<Role> findAll();
	public Role find(int id);
	
}
