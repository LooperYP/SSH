package cn.itcast.spring.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.spring.domain.Account;

public interface AccountDAO {
	
	public void save(Account account);
	
	public void update(Account account);
	
	public void delete(Account account);
	
	public List<Account> findAll();
	
	public Account findAccountByName();

	public List<Account> findAccountListByNameLike(DetachedCriteria criteria);

	public List<Account> findAccountListByNameLike(String queryName, String name);
}
