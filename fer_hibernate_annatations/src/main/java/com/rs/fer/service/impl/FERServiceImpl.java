package com.rs.fer.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.util.HibernateUtil;

public class FERServiceImpl implements FERService {

	@Override
	public boolean registration(User user) {
		return save(user);
	}

	@Override
	public boolean login(String username, String password) {
		boolean isValidUser = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", password));
		List<User> users =criteria.list();
		isValidUser =(users != null &&  !users.isEmpty());
			
		return isValidUser;
	}

	@Override
	public boolean addExpense(Expense expense) {
		return save(expense);
	}

	@Override
	public boolean editExpense(Expense expense) {
		
		return update(expense);
	}

	@Override
	public boolean deleteExpense(int expenseId) {
		boolean isDeleteExpense = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction =session.beginTransaction();
		try {
			Expense expense = new Expense();
			expense.setId(expenseId);
		session.delete(expense);
		transaction.commit();
		}catch(Exception ex) {
			isDeleteExpense = false;
		}
		session.close();
		
		return isDeleteExpense;
	}

	@Override
	public boolean resetPassword(int userId, String newPassword, String currentPassword) {
		boolean isResetPassword = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query =session.createQuery("update User u set u.password =:new where u.id=:userId and password =:current");
		query.setParameter("new",newPassword);
		query.setParameter("userId",userId);
		query.setParameter("current",currentPassword);
		Transaction transaction = session.beginTransaction();
		isResetPassword =query.executeUpdate() > 0 ;
		transaction.commit();
		session.close ();
		return isResetPassword;
	}

	@Override
	public List<Expense> getExpenseOptions(int userId) {
		List<Expense>expenses =null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Expense.class);
		criteria.add(Restrictions.eq("userId", userId));
		expenses = criteria.list();
		return expenses;
	}

	@Override
	public Expense getExpense(int ExpenseId) {

		return (Expense) get(Expense.class,ExpenseId);
	}

	@Override
	public List<Expense> getExpenseReport(int userId, String expenseType, String fromDate, String toDate) {
		
		List<Expense>expenses =null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Expense.class);
		criteria.add(Restrictions.eq("userId", userId));
		criteria.add(Restrictions.eq("type", expenseType));
		criteria.add(Restrictions.between("date",fromDate,toDate));
		expenses = criteria.list();
		return expenses;

		
	}

	@Override
	public User getUser(int UserId) {
		User user = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
      
        // Fetch the user
        user = (User) session.get(User.class, UserId);

        // Check if the user has an address
        if (user.getAddress()== null ) {
        	user.setAddress(new Address());
            
           
        }
         session.close();    

          return user;
	
	}

	@Override
	public boolean updateUser(User user) {
		return update(user);
	}

private  boolean save(Object object) {
	 boolean isSucess = false;
		Session session =HibernateUtil.getSessionFactory().openSession();
		Transaction transaction =session.beginTransaction();
		isSucess =(int) session.save(object) > 0;
		transaction.commit();
		session.close();
		
		return isSucess;
}
 private boolean update(Object object) {
	 boolean isUpdate = true;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
	   Transaction transaction =session.beginTransaction();	
		session.update(object);
		transaction.commit();
		
		}catch(Exception ex) {
			isUpdate = false;
			
			
		}
		session.close();
		
		return isUpdate;
     }
 private Object get(Class clazz,int id) {
	 Object object = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		object = session.get(clazz,id);
		session.close();
         return object;
    }
}
