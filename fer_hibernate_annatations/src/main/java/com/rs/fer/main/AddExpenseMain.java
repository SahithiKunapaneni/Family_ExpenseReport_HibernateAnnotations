package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class AddExpenseMain {

	public static void main(String[] args) {

		// 1.get the input

		Expense expense = new Expense();
		expense.setType("Watch");
		expense.setDate("25-07-24");
		expense.setPrice(2000);
		expense.setNumberOfItems(1);
		expense.setTotal(2000);
		expense.setByWhom("sai");
		expense.setUserId(2);

		// 2 call the service by passing the input to execute the bussiness logic

		FERService ferService = new FERServiceImpl();
		boolean isAddExpense = ferService.addExpense(expense);

		// 3 Show the status
		if (isAddExpense) {
			System.out.println("EXpense Added sucessfuly......");
		} else {
			System.out.println("Expense Add is failed");
		}
	}

}
