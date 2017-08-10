package cn.itcast.spring.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import cn.itcast.spring.domain.Account;
import cn.itcast.spring.service.AccountService;

@SuppressWarnings("serial")
public class AccountAction extends ActionSupport implements ModelDriven<Account> {
	
	private Account account = new Account();
	
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	private AccountService accountService;
	
	public Account getModel() {
		return account;
	}
	public String execute() throws Exception {
		return NONE;
	}
	
	public String add() throws Exception {
//		org.springframework.web.context.ContextLoaderListener ds;
//		org.springframework.orm.hibernate5.LocalSessionFactoryBean sf;
//		sf.setMappingResources(mappingResources);
//		sf.setHibernateProperties(hibernateProperties);
//		sf.setDataSource(dataSource);
		
		System.out.println("AccountAction..add");
		accountService.saveAccount(account);
		return NONE;
	}
}
