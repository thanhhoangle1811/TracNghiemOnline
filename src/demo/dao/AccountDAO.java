package demo.dao;

import demo.entities.*;
import java.util.*;

public interface AccountDAO {
	
	public Account create(Account account);
	public void setAccountRole(AccountRole accountRole);
	public Account getAccountById(int id);
	public Account getAccountByEmail(String email);
}
