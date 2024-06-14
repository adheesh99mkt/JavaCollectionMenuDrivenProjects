package com.app.custom_ordering;

import java.util.Comparator;

import com.app.banking.BankAccount;

public class BankAccountDobComparator implements Comparator<BankAccount> {
	@Override
	public int compare(BankAccount a1, BankAccount a2) {
		System.out.println("in compare -dob");
		return a1.getDob().compareTo(a2.getDob());
	}
}
