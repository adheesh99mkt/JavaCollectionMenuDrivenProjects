package com.app.validation;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;


import com.app.custException.CustException;
import com.app.customer.Customer;
import static com.app.validation.CustomerValidation.*;

public class CustomerUtils {
	public static Customer signIn(String email,String password,List<Customer> customer) throws CustException {
		SignInEmailValidation(email,customer);
		Customer cust=new Customer(email);
		int index=customer.indexOf(cust);
		cust=customer.get(index);
		if(cust.getPassword().equals(password)) {
			return cust;
		}
		throw new CustException("Wrong password!");
	}
	public static void changePassword(Customer cust,String newPass) throws CustException {
		passwordMatching(newPass);
		cust.setPassword(newPass);
	}
	public static void removeUser(String email,String password,List<Customer> customer) throws CustException {
		Customer cust=signIn(email, password, customer);
		customer.remove(cust);
	}
	public static void removeUsingSpecDate(String date,List<Customer> customer) {
		LocalDate dt=parseDate(date);
//		for (Customer cust : customer) {
//			if(cust.getDob().equals(dt)) {
//				customer.remove(cust);
//			}
//		}
		Iterator<Customer> itr=customer.iterator();
		while(itr.hasNext()) {
			if(itr.next().getDob().equals(dt)) {
				itr.remove();
			}
		}
	}
	
}
