package com.app.contactorderingsort;

import java.util.Comparator;

import com.app.contact.Contact;

public class ContactSortPhone implements Comparator<Contact> {

	@Override
	public int compare(Contact o1, Contact o2) {
		// TODO Auto-generated method stub
		return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
	}

}
