package com.app.customcontactordering;

import java.util.Comparator;

import com.app.contact.Contact;

public class ContactSortEmailandPhone implements Comparator<Contact> {

	@Override
	public int compare(Contact c1, Contact c2) {
		int phoneval=c1.getPhoneNumber().compareTo(c2.getPhoneNumber());
		if(phoneval==0) {
			return c1.getEmail().compareTo(c2.getEmail());
		}
		return phoneval;
	}

}
