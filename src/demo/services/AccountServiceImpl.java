package demo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.AccountDAO;
import demo.entities.*;

@Service("accountService")
@Transactional
public class AccountServiceImpl 
	implements AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	
	@Override
    public void setAccountRole(AccountRole accountRole) {
	    accountDAO.setAccountRole(accountRole);
    }


    @Override
	public Account create(Account account) {
		return accountDAO.create(account);
	}

}
