package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetExpenseMain {

	public static void main(String[] args) {

		// 1.get the input

		int ExpenseId = 2;

		// 2 call the service by passing the input to execute the bussiness logic

		FERService ferService = new FERServiceImpl();
		Expense expense = ferService.getExpense(ExpenseId);

		// 3 Show the status
		if (expense == null) {
			System.out.println("No Expense found ....");
		} else {

			System.out.println("ID :" + expense.getId());
			System.out.println("Type :" + expense.getType());
			System.out.println("Date :" + expense.getDate());
			System.out.println("Price :" + expense.getPrice());
			System.out.println("Number of Items :" + expense.getNumberOfItems());
			System.out.println("Total :" + expense.getTotal());
			System.out.println("By Whom :" + expense.getByWhom());
			System.out.println(" User Id : " + expense.getUserId());

			System.out.println("...........................");

		}
	}

}
