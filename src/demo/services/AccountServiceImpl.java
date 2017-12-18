package demo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.AccountDAO;
import demo.entities.Account;
import demo.entities.*;

@Service("accountService")
@Transactional
public class AccountServiceImpl 
	implements AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	@Override
	public Account create(Account account) {
		return accountDAO.create(account);
	}

}
