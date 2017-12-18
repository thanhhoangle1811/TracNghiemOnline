package demo.services;

import demo.entities.*;
import java.util.*;

public interface RoleService {

	public List<Role> findAll();
	public Role find(int id);
	
}
