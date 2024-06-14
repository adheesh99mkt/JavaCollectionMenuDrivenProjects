package com.app.utils;

import java.util.Map;

import com.app.contact.Contact;
import com.app.contact.ContactID;
import com.app.contactexception.ContactCustomeException;
import static com.app.utils.ContactValidation.*;

public class ContactUtility {
	public static Contact updateContact(ContactID contId,Map<ContactID, Contact> contact) throws ContactCustomeException {
		if(contact.containsKey(contId)) {
			Contact cont=contact.get(contId);
			if(cont!=null) {
				return cont;
			}
		}
		throw new ContactCustomeException("Contact not found!");
	}
	public static void display(Map<ContactID, Contact> contact) {
		for(Contact c:contact.values()) {
			System.out.println(c);
		}
	}
	public static Contact deleteContact(ContactID contId,Map<ContactID, Contact> contact) throws ContactCustomeException {
		if(contact.containsKey(contId)) {
			Contact cont=contact.remove(contId);
			return cont;
		}
		throw new ContactCustomeException("Contact not found!");
		
	}
	
	public static ContactID removeBasedCountry(String country,Map<ContactID, Contact> contact) throws ContactCustomeException {
			for(Contact c:contact.values()) {
				if(validateAndParseCountry(country)==c.getCountry()) {
					return c.getContactid();
				}
			}
			throw new ContactCustomeException("No Contact containing this country!");
	}
}
