package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class RegistrationMain {

	public static void main(String[] args) {

		// 1.get the input

		User user = new User();
		user.setFirstName("srtyu");
		user.setMiddleName("");
		user.setLastName("Wxyz");
		user.setEmail("abcd@xyz.com");
		user.setUsername("ABCD");
		user.setPassword("xyz@123");
		user.setMobile("0987654321");

		// 2 call the service by passing the input to execute the bussiness logic

		FERService ferService = new FERServiceImpl();
		boolean isRegister = ferService.registration(user);

		// 3 Show the status
		if (isRegister) {
			System.out.println("User registration is done sucessfuly......");
		} else {
			System.out.println("User registration is failed");
		}

	}

}
