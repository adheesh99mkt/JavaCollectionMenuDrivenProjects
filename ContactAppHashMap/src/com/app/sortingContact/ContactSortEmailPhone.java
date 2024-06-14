package com.app.sortingContact;

import java.util.Comparator;

import com.app.contact.Contact;

public class ContactSortEmailPhone implements Comparator<Contact>{

	@Override
	public int compare(Contact o1, Contact o2) {
		// TODO Auto-generated method stub
		int val=o1.getEmail().compareTo(o2.getEmail());
		if(val==0) {
			return o1.getPhoneNum().compareTo(o2.getPhoneNum());
		}
		return val;
	}

}
