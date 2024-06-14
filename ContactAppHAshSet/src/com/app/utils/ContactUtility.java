package com.app.utils;

import java.util.Iterator;
import java.util.Set;

import com.app.contact.Contact;
import com.app.contact.CountryCode;
import com.app.contactexception.ContactCustomeException;

import static com.app.utils.ContactValidation.*;

public class ContactUtility {
	public static Contact updateNumber(String name,String dob,Set<Contact> contact) throws ContactCustomeException {
		Contact cont=new Contact(name, parseDate(dob));
		if(contact.contains(cont)) {
			return cont;
		}
		throw new ContactCustomeException("Contact Not found!");
	}
	public static void displayAll(Set<Contact> contact) {
		for(Contact c:contact) {
			System.out.println(c);
		}
	}
	public static Contact deleteContact(String name,String date,Set<Contact> contact) throws ContactCustomeException {
		Contact cont=new Contact(name,parseDate(date));
		if(contact.contains(cont)) {
			return cont;
		}
		throw new ContactCustomeException("Contact not found!");
		
	}
	public static void removeBasedOnCountry(String country,Set<Contact> contact) throws ContactCustomeException {
		CountryCode c=parseAndValidateCountryCode(country);
		Iterator<Contact> itr=contact.iterator();
		while(itr.hasNext()) {
			if(itr.next().getCountry()==c) {
				itr.remove();
			}
		}
	}
	
}
