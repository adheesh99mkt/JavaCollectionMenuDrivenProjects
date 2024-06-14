package com.app.utils;

import java.time.LocalDate;
import java.util.Map;

import com.app.contact.Contact;
import com.app.contact.ContactID;
import com.app.contact.CountryCode;
import com.app.contactexception.ContactCustomeException;

public class ContactValidation {
	public static void validatePhone(String number) throws ContactCustomeException {
		if(number.length()!=10) {
			throw new ContactCustomeException("Phone number is not valid!");
		}
	}
	public static void validateEmail(String email) throws ContactCustomeException {
		if(!(email.matches(Contact.emailFormat))) {
			throw new ContactCustomeException("Email is not valid!");
		}
	}
	public static void validateNameAndDob(ContactID contId,Map<ContactID,Contact> contact) throws ContactCustomeException {
		if(contact.containsKey(contId)) {
			throw new ContactCustomeException("Contact is present");
		}
	}
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
		
	}
	public static CountryCode validateAndParseCountry(String country) throws ContactCustomeException {
	CountryCode c=CountryCode.valueOf(country.toUpperCase());
		if(c!=null) {
			return c;
		}
	throw new ContactCustomeException("Country not found!");
		
	}
	public static Contact validateAllInput(ContactID contId,String country,String phone,String email
			,Map<ContactID, Contact> contact) throws ContactCustomeException {
		validateNameAndDob(contId, contact);
		validatePhone(phone);
		validateEmail(email);
		CountryCode nation=validateAndParseCountry(country);
		int code=nation.getCode();
		return new Contact(contId ,nation,phone,email,code);
		
	}
	
}
