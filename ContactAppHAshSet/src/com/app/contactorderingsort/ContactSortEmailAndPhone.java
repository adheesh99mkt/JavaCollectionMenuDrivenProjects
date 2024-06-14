package com.app.contactorderingsort;

import java.util.Comparator;

import com.app.contact.Contact;

public class ContactSortEmailAndPhone implements Comparator<Contact> {

	@Override
	public int compare(Contact o1, Contact o2) {
		int val=o1.getEmail().compareTo(o2.getEmail());
		if(val==0) {
			return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
		}
		return val;
	}

}
