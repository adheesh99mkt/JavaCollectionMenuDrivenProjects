package com.app.customcontactordering;

import java.util.Comparator;

import com.app.contact.Contact;

public class ContactSortEmail implements Comparator<Contact> {

	@Override
	public int compare(Contact c1, Contact c2) {
		return c1.getEmail().compareTo(c2.getEmail());
	}

}
