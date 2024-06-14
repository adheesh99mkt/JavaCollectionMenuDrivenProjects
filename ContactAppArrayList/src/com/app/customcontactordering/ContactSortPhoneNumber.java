package com.app.customcontactordering;

import java.util.Comparator;

import com.app.contact.Contact;

public class ContactSortPhoneNumber implements Comparator<Contact> {

	@Override
	public int compare(Contact c1, Contact c2) {
		return c1.getPhoneNumber().compareTo(c2.getPhoneNumber());
	}

}
