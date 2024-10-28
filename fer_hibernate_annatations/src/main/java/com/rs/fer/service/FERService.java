package com.rs.fer.service;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;

public interface FERService {

	boolean registration(User user);

	boolean login(String username, String password);

	boolean addExpense(Expense expense);

	boolean editExpense(Expense expense);

	boolean deleteExpense(int expenseId);

	boolean resetPassword(int userId, String newPassword, String currentPassword);

	List<Expense> getExpenseOptions(int userId);

	Expense getExpense(int ExpenseId);

	List<Expense> getExpenseReport(int userId, String expenseType, String fromDate, String toDate);

	User getUser(int UserId);

	boolean updateUser(User user);
}
