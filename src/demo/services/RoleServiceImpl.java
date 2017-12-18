package demo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.RoleDAO;
import demo.entities.*;

@Service("roleService")
@Transactional
public class RoleServiceImpl 
	implements RoleService {

	@Autowired
	private RoleDAO roleDAO;
	
	@Override
	public List<Role> findAll() {
		return roleDAO.findAll();
	}

	@Override
	public Role find(int id) {
		return roleDAO.find(id);
	}

}
