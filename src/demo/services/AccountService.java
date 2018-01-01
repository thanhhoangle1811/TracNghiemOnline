package demo.services;

import demo.entities.*;
import java.util.*;

public interface AccountService {

	public Account create(Account account);
	public void setAccountRole(AccountRole accountRole);
	public Account getAccountById(int id);
	public Account getAccountByEmail(String email);
}
