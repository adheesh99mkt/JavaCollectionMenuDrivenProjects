package com.app.customerValidate;


import static com.app.customerValidate.CustValidate.*;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.app.custException.custException;
import com.app.customer.Customer;
import com.app.customer.PlanType;


public class CustomerUtility {
	//sign in
	public static Customer customerSignIn(String email,String password,Map<String,Customer> customer) throws custException{
		emailValidate(email,customer);
		if(customer.containsKey(email)) {
			for(Customer c: customer.values()) {
				if(password.equals(c.getPassword())){
					return c;
				}
			}
			
		}
		throw new custException("Credentials are Not Matching..customer can't sign in!");
		
	}
	//change password
	public static Customer changePassword(String email,String oldpassword,Map<String,Customer> customer) throws custException {
		emailValidate(email, customer);
		if(customer.containsKey(email)) {
			for(Customer c:customer.values()) {
				if(oldpassword.equals(c.getPassword())) {
					return c;
				}
			
			}
		}
		throw new custException("Credentials are Not Matching..Password can't change!");
		
	}
	//delete customer
	public static String deleteCustomer(String email,String password,Map<String,Customer> customer) throws custException {
		if(customer.containsKey(email)) {
			Customer cust=customer.remove(email);
				return "Customer removed!";
			}
		throw new custException("Credentials are Not Matching..Account can't be deleted!");	
	}
	//display
	public static void display(Map<String,Customer> customer) {
		for(Customer c:customer.values()) {
			System.out.println(c);
		}
	}
	public static void removePlanAfterSpecifiedDate(String plan,String date,Map<String,Customer> customer) {
		LocalDate d=parseDate(date);
		PlanType p=validateAndParseService(plan);
		for(Customer c:customer.values()) {
				if(c.getPlan()==p) {
					if((c.getDob()).isAfter(d)) {
					for(String key:customer.keySet()) {
						if(key.equals(c.getEmail())) {
							customer.remove(key);
						}
					}
				}
			}
		}
			
		}
//	public static Customer custAge(String email,List<Customer> customer) {
//		return null;
//		
//	}
//	public static Customer getCustomerByEmail(String email,List<Customer> customer) {
//		return null;
//	}
}
