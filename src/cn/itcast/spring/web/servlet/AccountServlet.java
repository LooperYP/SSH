package cn.itcast.spring.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.itcast.spring.service.AccountService;

public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		ApplicationContext applicationContext = (ApplicationContext) getServletContext().getAttribute(WebApplicationContext.class.getName() + ".ROOT");
		ApplicationContext applicationContext = WebApplicationContextUtils.findWebApplicationContext(getServletContext());
		
		AccountService accountService = (AccountService) applicationContext.getBean("accountService");
		accountService.findAccountListByNameLike("");
		System.out.println(applicationContext.hashCode());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
