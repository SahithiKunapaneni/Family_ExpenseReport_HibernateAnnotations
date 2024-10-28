package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class DeleteExpenseMain {

	public static void main(String[] args) {

		// 1.get the input
		int expenseId = 6;

		// 2 call the service by passing the input to execute the bussiness logic

		FERService ferService = new FERServiceImpl();
		boolean isDeleteExpense = ferService.deleteExpense(expenseId);

		// 3 Show the status
		if (isDeleteExpense) {
			System.out.println("Expense Deleted  sucessfuly......");
		} else {
			System.out.println("Delete is failed");
		}

	}

}
