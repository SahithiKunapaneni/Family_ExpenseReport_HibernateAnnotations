package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class ResetPasswordMain {

	public static void main(String[] args) {

		// 1.get the input
		int userId = 1;
		String newPassword = "Vinu";
		String currentPassword = "XYZ@123";
		// 2 call the service by passing the input to execute the bussiness logic

		FERService ferService = new FERServiceImpl();
		boolean isResetPassword = ferService.resetPassword(userId, newPassword, currentPassword);

		// 3 Show the status
		if (isResetPassword) {
			System.out.println("Password  Updated sucessfuly......");
		} else {
			System.out.println("Password Update is failed");
		}

	}

}
