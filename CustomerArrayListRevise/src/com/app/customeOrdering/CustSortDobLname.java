package com.app.customeOrdering;

import java.util.Comparator;

import com.app.customer.Customer;

public class CustSortDobLname implements Comparator<Customer> {

	@Override
	public int compare(Customer o1, Customer o2) {
		int val=o1.getDob().compareTo(o2.getDob());
		if(val==0) {
			return o1.getLname().compareTo(o2.getLname());
		}
		return val;
	}

}
