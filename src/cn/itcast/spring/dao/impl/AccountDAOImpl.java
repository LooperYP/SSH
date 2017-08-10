package cn.itcast.spring.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import cn.itcast.spring.dao.AccountDAO;
import cn.itcast.spring.domain.Account;

@SuppressWarnings("unused")
public class AccountDAOImpl extends HibernateDaoSupport implements AccountDAO {
	
//	public void setSuperSessionFactory(SessionFactory sessionFactory) {
//		super.setSessionFactory(sessionFactory);
//	}

	@Override
	public void save(Account account) {
		getHibernateTemplate().save(account);
	}

	@Override
	public void update(Account account) {
		getHibernateTemplate().update(account);
	}

	@Override
	public void delete(Account account) {
		getHibernateTemplate().delete(account);
	}

	@Override
	public List<Account> findAll() {
		return getHibernateTemplate().loadAll(Account.class);
	}

	@Override
	public Account findAccountByName() {
		
		return null;
	}

	@Override
	public List<Account> findAccountListByNameLike(DetachedCriteria criteria) {
		List<Account> byCriteria = (List<Account>) getHibernateTemplate().findByCriteria(criteria);
		return byCriteria;
	}

	@Override
	public List<Account> findAccountListByNameLike(String queryName, String name) {
		return (List<Account>) getHibernateTemplate().findByNamedQuery(queryName, name);
	}
	
	
}
