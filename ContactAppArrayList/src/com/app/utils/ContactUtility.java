package com.app.utils;

import java.util.Iterator;
import java.util.List;

import com.app.contact.Contact;
import com.app.contact.CountryCode;
import com.app.contactexception.ContactException;

import static com.app.utils.ValidateContact.*;

public class ContactUtility {
	public static Contact updateNumber(String name,String dob,List<Contact> contact) throws ContactException {
		Contact cont=new Contact(name, parseDate(dob));
		if(contact.contains(cont)) {
			int index=contact.indexOf(cont);
			return contact.get(index);
		}
		throw new ContactException("Contact not found!");
		
	}
	public static void displayAllContact(List<Contact> contact) {
		for(Contact c: contact) {
			System.out.println(c);
		}
	}
	public static void removeBasedOnCountry(String country,List<Contact> contact) throws ContactException {
		CountryCode c=validateCountryCode(country);
		Iterator<Contact> itr=contact.iterator();
		while(itr.hasNext()) {
			if(itr.next().getCountry()==c) {
				itr.remove();
			}
		}
	}
	public static int deleteContact(String name,String dob,List<Contact> contact) throws ContactException {
		Contact cont=new Contact(name, parseDate(dob));
		if(contact.contains(cont)) {
			return contact.indexOf(cont);
		}
		throw new ContactException("Contact not found!");
		
	}
}
