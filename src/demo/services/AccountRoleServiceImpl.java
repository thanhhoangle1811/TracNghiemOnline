package demo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.AccountDAO;
import demo.dao.AccountRoleDAO;
import demo.entities.Account;
import demo.entities.*;

@Service("accountRoleService")
@Transactional
public class AccountRoleServiceImpl 
	implements AccountRoleService {

	@Autowired
	private AccountRoleDAO accountRoleDAO;
	
	@Override
	public void create(AccountRole accountRole) {
		accountRoleDAO.create(accountRole);
	}

}
