package com.app.validation;

import java.util.Set;

import com.app.custexception.CustException;
import com.app.customer.Customer;

public class CustomerUtils {
	public static void signIn(String email,String password,Set<Customer> customer) throws CustException {
		Customer cust=new Customer(email);
		if(customer.contains(cust)) {
			if(!(password.equals(cust.getPassword()))){
				throw new CustException("Wrong password!");
			}
		}
		throw new CustException("User is not found!");
	}
	
}
