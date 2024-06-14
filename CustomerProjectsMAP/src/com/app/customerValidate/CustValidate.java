package com.app.customerValidate;
import java.time.Period;
import java.time.LocalDate;
import com.app.customer.Customer;
import com.app.customer.PlanType;


import java.util.List;
import java.util.Map;

import com.app.custException.*;

public class CustValidate {
	public static void signUpEmailValidate(String email,Map<String,Customer> customer) throws custException {
		if(customer.containsKey(email))
				throw new custException("Customer Already exists!");
		System.out.println("New Customer!");
	}
	public static String emailValidate(String email,Map<String,Customer> customer) throws custException {
		if(customer.containsKey(email))
				return "user found..continue";
		else{
			throw new custException("Customer not found!");
		}
	}
	public static void emailFormatValidate(String email) throws custException {
		if(!(email.matches(Customer.emailTemplate))) {
			throw new custException("Please fill with the Standared email format!");
		}
	}
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
		
	}
	public static PlanType validateAndParseService(String type) {
		return PlanType.valueOf(type.toUpperCase());
	}
	public static void validatePlanCharge(PlanType plan,double regAmount) throws custException {
		if(regAmount<plan.getCharges()) {
			throw new custException("Registration amount is not enough!!!");
		}
		System.out.println("registration amount is debited successfully...");
	}
	public static void validatePassword(String pass) throws custException {
		if(!(pass.matches(Customer.passwordTemplate))) {
			throw new custException("Password is not acceptable!!!");
		}
	}
	public static void ageValidation(LocalDate dob) throws custException {
		int age= Period.between(dob,LocalDate.now()).getYears();
		if(age<18) {
			throw new custException("You are below the age limit!!!");
		}
	}
	
	
	public static Customer validateAllInput(String fname,String lname,String email,String password,double regAmount,String dob,String plan,Map<String,Customer> customer) throws custException {
		emailFormatValidate(email);
		signUpEmailValidate(email, customer);
		validatePassword(password);
		LocalDate DOB=parseDate(dob);
		ageValidation(DOB);
		PlanType type=validateAndParseService(plan);
		validatePlanCharge(type, regAmount);
		return new Customer(fname, lname, email, password, regAmount, DOB, type);
		
	}
		
}

