package com.rs.fer.main;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class EditExpenseMain {

	public static void main(String[] args) {

		// 1.get the input
          
		Expense expense = new Expense();
		expense.setType("Room");
		expense.setDate("21-07-24");
		expense.setPrice(20);
		expense.setNumberOfItems(5);
		expense.setTotal(100);
		expense.setByWhom("Me");
		expense.setUserId(2);
		expense.setId(3);

		// 2 call the service by passing the input to execute the bussiness logic

		FERService ferService = new FERServiceImpl();
		boolean isEditExpense = ferService.editExpense(expense);

		// 3 Show the status
		if (isEditExpense) {
			System.out.println("EXpense Updated sucessfuly......");
		} else {
			System.out.println("Expense Update is failed");
		}
	}

}
