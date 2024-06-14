package com.app.custOrdering;

import java.util.Comparator;

import com.app.customer.Customer;

public class CustDobLastnameSort implements Comparator<Customer> {

	@Override
	public int compare(Customer c1, Customer c2) {
		int sortVal=c1.getDob().compareTo(c2.getDob());
		if(sortVal==0) {
			return c1.getLname().compareTo(c2.getLname());
		}
		return sortVal;
	}

}
