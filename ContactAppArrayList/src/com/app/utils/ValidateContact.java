package com.app.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.app.contact.*;
import com.app.contactexception.ContactException;

public class ValidateContact {
	public static void validatePhoneNumber(String number) throws ContactException {
		if(number.length()!=10) {
			throw new ContactException("Phone number is not Valid!");
		}
	}
	public static void validateEmail(String email) throws ContactException {
		if(!(email.matches(Contact.emailFormat))) {
			throw new ContactException("Email is not Valid!");
		}
		
	}
	public static void validateNameAndDob(String name,String dob,List<Contact> contact) throws ContactException {
		Contact cont=new Contact(name, parseDate(dob));
		if(contact.contains(cont)) {
			throw new ContactException("Contact Already Exists...!");
		}
	}
	public static CountryCode validateCountryCode(String country) throws ContactException {
		CountryCode c=CountryCode.valueOf(country.toUpperCase());
		if(c!=null) {
			return c;
		}
		throw new ContactException("Country not found!");
		
	}
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}
	public static void validateAge(LocalDate dob) throws ContactException {
		if(Period.between(dob,LocalDate.now()).getYears()<18) {
			throw new ContactException("You are Below Age Limit!");
		}
	}
	public static Contact validateAllInputs(String country,String number,String name,String dob,String email,List<Contact> contact) throws ContactException {
		validateNameAndDob(name, dob, contact);
		CountryCode nation=validateCountryCode(country);
		validatePhoneNumber(number);
		validateEmail(email);
		int codeVal=nation.getCode();
		LocalDate date=parseDate(dob);
		validateAge(date);
		
		return new Contact( nation, number, name, date, email, codeVal);
		
	}
	
}
