package cn.itcast.spring.test;

import static org.junit.Assert.*;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.ContextLoaderListener;
import com.opensymphony.xwork2.ModelDriven;
import cn.itcast.spring.domain.Account;
import cn.itcast.spring.service.AccountService;

@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class AccountServiceTest {
	
	@Autowired
	private AccountService accountService;
	
	@Test
	public void test() {
		ContextLoaderListener cl = null;
		LocalSessionFactoryBean lsfb = null;
//		lsfb.setDataSource(dataSource);
//		lsfb.setHibernateProperties(hibernateProperties);
//		lsfb.setMappingResources(mappingResources);
//		HibernateTransactionManager tm = null;
//		tm.setDataSource(dataSource);
//		tm.setSessionFactory(sessionFactory);
	}

	@Test
	public void testSaveAccount() {
		Account account = new Account();
		account.setName("Looper");
		account.setMoney(2017d);
		accountService.saveAccount(account);
	}

	@Test
	public void testUpdateAccount() {
		Account account = new Account();
		account.setId(1);
		account.setName("Jack");
		account.setMoney(998d);
		accountService.updateAccount(account);
	}

	@Test
	public void testDeleteAccount() {
		Account account = new Account();
		account.setId(5);
		accountService.deleteAccount(account);
	}

	@Test
	public void testFindAllAccountList() {
		List<Account> list = accountService.findAllAccountList();
		System.out.println(list);
	}

	@Test
	public void testFindAccountByNameLikeQBC() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Account.class);
		criteria.add(Restrictions.ilike("name", "%J%"));
		List<Account> list = accountService.findAccountListByNameLike(criteria);
		System.out.println(list);
	}

	@Test
	public void testFindAccountByNameLikeQBN() {
		List<Account> list = accountService.findAccountListByNameLike("%J%");
		System.out.println(list);
	}
}
