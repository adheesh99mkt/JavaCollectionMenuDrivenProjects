package com.app.validation;

import java.time.LocalDate;
import java.util.List;

import com.app.custException.CustException;
import com.app.customer.Customer;
import com.app.customer.PlanType;

public class CustomerValidation {
	public static void emailMatching(String email) throws CustException {
		if(!(email.matches(Customer.emailTemp))) {
			throw new CustException("Email format is not valid...");
		}
	}
	public static void passwordMatching(String password) throws CustException {
		if(!(password.matches(Customer.passTemp))) {
			throw new CustException("Password format is not acceptable!");
		}
	}
	public static void SignUpEmailValidation(String email,List<Customer> customer) throws CustException {
		Customer cust=new Customer(email);
		if(customer.contains(cust)) {
			throw new CustException("User already present!");
		}
	}
	public static void SignInEmailValidation(String email,List<Customer> customer) throws CustException {
		Customer cust=new Customer(email);
		if(!(customer.contains(cust))) {
			throw new CustException("User not present..just register by clicking 1");
		}
	}
	public static PlanType parsePlanType(String planType) throws CustException {
		PlanType plan=PlanType.valueOf(planType.toUpperCase());
		if(plan==null) {
			throw new CustException("Plan is not valid!");
		}
		return plan;
	}
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}
	public static void validateRegAmount(double amount,PlanType plan) throws CustException {
		if(amount<plan.getCharges()) {
			throw new CustException("Registration amount is not sufficiant!");
		}
	}
	public static Customer validateAllInput(String email, String fname, String lname, String password,
			double regAmount,String dob, String plan,List<Customer> customer) throws CustException {
		emailMatching(email);
		passwordMatching(password);
		SignUpEmailValidation(email,customer);
		PlanType planType=parsePlanType(plan);
		LocalDate dt=parseDate(dob);
		validateRegAmount(regAmount,planType);
		
		return new Customer(email, fname, lname, password, regAmount, dt, planType);

	}
}
