package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetUserMain {

	public static void main(String[] args) {

		// 1.get the input

		int UserId = 1;

		// 2 call the service by passing the input to execute the bussiness logic

		FERService ferService = new FERServiceImpl();
		User user = ferService.getUser(UserId);

		// 3 Show the status
		if (user == null) {
			System.out.println("No user found ....");
		} else {

			// name info
			System.out.println(".....Name Info......");
			System.out.println("First Name :" + user.getFirstName());
			System.out.println("Middle Name :" + user.getMiddleName());
			System.out.println("Last Name :" + user.getLastName());
			System.out.println("........................");
			System.out.println(".....Contact Info......");
			System.out.println("Email Id :" + user.getEmail());
			System.out.println("Mobile :" + user.getMobile());
			Address address = user.getAddress();

			System.out.println(".....Address......");

			System.out.println("Line1 :" + address.getLineOne());
			System.out.println("Line2:" + address.getLineTwo());
			System.out.println("City :" + address.getCity());
			System.out.println("State :" + address.getState());
			System.out.println("Pin Code:" + address.getPinCode());
			System.out.println("Country :" + address.getCountry());

		}
	}

}
