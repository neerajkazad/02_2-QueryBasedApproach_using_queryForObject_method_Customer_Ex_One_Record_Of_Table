package com.qa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qa.bo.CustomerBo;
import com.qa.dao.CustomerDao;

public class QATest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/qa/common/application-context.xml");
		CustomerDao cDao = context.getBean("customerDao", CustomerDao.class);
		/*int n = cDao.getCountNoOfCustomer();
		System.out.println("Count : "+n);*/
		
		/*String firstName = cDao.findCustomerFirstName("9876543210");
		System.out.println("Customer FirstName : "+ firstName);*/
		CustomerBo bo = cDao.findCustomer(1);
		System.out.println(bo);
	}
}
