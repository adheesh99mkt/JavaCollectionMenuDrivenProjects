package com.app.sortingContact;


import java.util.Comparator;

import com.app.contact.Contact;

public class ContactEmailSort implements Comparator<Contact>{

	@Override
	public int compare(Contact o1, Contact o2) {
		return o1.getEmail().compareTo(o2.getEmail());
	}

}
