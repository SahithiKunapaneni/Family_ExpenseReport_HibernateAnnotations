package com.rs.fer.ex;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.util.HibernateUtil;


public class GetUserMain {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
	User user = (User)session.get(User.class,1);
	System.out.println("get user object");
	System.out.println(user.getUsername());
	if(user.getAddress()!=null) {
		System.out.println("Address:"+user.getAddress().getCity());
	}
	Set<Expense> expenses = user.getExpenses();
	System.out.println("expense created");
	
	Iterator<Expense> iterator = expenses.iterator();
	
	System.out.println("iterator object");
	Expense expense = null;
	while(iterator.hasNext()) {
		expense = iterator.next();
		System.out.println(expense.getTotal());
	}
	session.close();
}
}
