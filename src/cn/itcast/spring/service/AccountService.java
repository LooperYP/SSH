package cn.itcast.spring.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.spring.domain.Account;

public interface AccountService {
	
	public void saveAccount(Account account);
	
	public void updateAccount(Account account);
	
	public void deleteAccount(Account account);
	
	public List<Account> findAllAccountList();
	
	List<Account> findAccountListByNameLike(DetachedCriteria criteria);

	List<Account> findAccountListByNameLike(String name);
}
