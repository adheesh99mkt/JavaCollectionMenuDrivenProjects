package com.app.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

import com.app.contact.Contact;
import com.app.contact.CountryCode;
import com.app.contactexception.ContactCustomeException;

public class ContactValidation {
	public static void validateNumber(String number) throws ContactCustomeException {
		if(number.length()!=10) {
			throw new ContactCustomeException("Phone number is not Valid!");
		}
	}
	public static void validateEmailFormat(String email) throws ContactCustomeException {
		if(!(email.matches(Contact.emailFormat))) {
			throw new ContactCustomeException("Email is not Valid!");
		}
	}
	public static void validateAge(LocalDate dob) throws ContactCustomeException {
		if(Period.between(dob, LocalDate.now()).getYears()<18) {
			throw new ContactCustomeException("You are below the age limit!");
		}
	}
	public static LocalDate parseDate(String dob) {
		return LocalDate.parse(dob);
	}
	public static CountryCode parseAndValidateCountryCode(String country) throws ContactCustomeException {
		CountryCode cnt=CountryCode.valueOf(country.toUpperCase());
		if(cnt==null) {
			throw new ContactCustomeException("Country is not available!");
		}
		return cnt;
	}
	public static void validateNameAndDob(String name,LocalDate dob,Set<Contact> contact) throws ContactCustomeException {
		Contact cont=new Contact(name, dob);
		if(contact.contains(cont)) {
			throw new ContactCustomeException("Contact Alresdy Exists!");
		}
	}
	public static Contact validateAllInput(String number,String name,String dob,String email,String country,Set<Contact> contact) throws ContactCustomeException {
		
		LocalDate DOB=parseDate(dob);
		validateNameAndDob(name, DOB, contact);
		validateNumber(number);
		validateEmailFormat(email);
		validateAge(DOB);
		CountryCode nation=parseAndValidateCountryCode(country);
		int code=nation.getCode();
		return new Contact(number, name, DOB, email, nation, code);
		
	}
}
