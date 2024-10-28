package com.rs.fer.ex;

import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;


public class RelationalExample {
	public static void main(String[] args) {
	System.out.println("Maven + Hibernate + MySQL");
	
       Address address = new Address();
	  
         Set<Expense> expenses = new LinkedHashSet<>();
         Expense expense = new Expense();
         expense.setTotal(100);
         expenses.add(expense);
         
         expense = new Expense();
         expense.setTotal(200);
         expenses.add(expense);
         
         expense = new Expense();
         expense.setTotal(300);
         expenses.add(expense);
         
         expense = new Expense();
         expense.setTotal(400);
         expenses.add(expense);
         
         expense = new Expense();
         expense.setTotal(500);
         expenses.add(expense);
         
         User user = new User();
         
         user.setEmail("sai@gmail.com");
         user.setAddress(address);
         user.setExpenses(expenses);
         
	// 1 Load the Hibernate configuration
	
	Configuration configuration = new Configuration();
	configuration.configure("hibernate.cfg.xml");
	
	// 2 Build the Session factory 
	
	SessionFactory sessionFactory = configuration.buildSessionFactory();
	
	// 3 Open the session
	Session session = sessionFactory.openSession();
	// 4 Begin the transaction
	Transaction transaction = session.beginTransaction();
	
	// 5 Actual call 
	session.save(user);
	// 6 Commit the transaction 
	
	transaction.commit();
	
	// 7 Close the session 
	
	session.close();

	}
}
