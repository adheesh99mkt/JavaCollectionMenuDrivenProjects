package com.app.contactorderingsort;

import java.util.Comparator;

import com.app.contact.Contact;

public class ContactSortEmail implements Comparator<Contact> {

	@Override
	public int compare(Contact o1, Contact o2) {
		// TODO Auto-generated method stub
		return o1.getEmail().compareTo(o2.getEmail());
	}

}