package com.app.validation;

import java.time.LocalDate;
import java.util.Set;

import com.app.custexception.CustException;
import com.app.customer.Customer;
import com.app.customer.PlanType;

public class CustomerValidation {
	public static void emailMatching(String email) throws CustException {
		if(!(email.matches(Customer.emailTemp))) {
			throw new CustException("Email format is not valid!");
		}
	}
	public static void passwordMatching(String password) throws CustException {
		if(!(password.matches(Customer.passTemp))) {
			throw new CustException("Password format is not valid!");
		}
	}
	public static void validateEmailSignUp(String email,Set<Customer> customer) throws CustException {
		Customer cust=new Customer(email);
		if(customer.contains(cust)) {
			throw new CustException("User already present!");
		}
	}
	public static void validateEmailSignIn(String email,Set<Customer> customer) throws CustException {
		Customer cust=new Customer(email);
		if(!(customer.contains(cust))) {
			throw new CustException("User not found!");
		}
	}
	public static PlanType parsePlan(String plan) throws CustException {
		PlanType plantype=PlanType.valueOf(plan.toUpperCase());
		if(plantype==null) {
			throw new CustException("Plan not found!");
		}
		return plantype;
	}
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}
	public static void validateRegAmount(double amount,PlanType plan) throws CustException {
		if(amount<plan.getCharges()) {
			throw new CustException("Amount is not sufficient !");
		}
	}
	public static Customer validateAllInput(String email, String fname, String lname, String password, double regAmount,
			String dob, String plan,Set<Customer> customer) throws CustException {
		emailMatching(email);
		passwordMatching(password);
		validateEmailSignUp(email, customer);
		PlanType plantype=parsePlan(plan);
		LocalDate date=parseDate(dob);
		validateRegAmount(regAmount, plantype);
		
		return new Customer(email, fname, lname, password, regAmount, date, plantype);
	}
}
