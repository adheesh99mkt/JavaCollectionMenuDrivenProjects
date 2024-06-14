package com.app.custom_ordering;

import java.util.Comparator;

import com.app.banking.BankAccount;

public class BankAccountDobBalanceComparator implements Comparator<BankAccount> {

	@Override
	public int compare(BankAccount o1, BankAccount o2) {
		System.out.println("in compare - dob n bal");
		// dob based comparison
		int retVal = o1.getDob().compareTo(o2.getDob());
		if (retVal == 0) {
			// compare as per desc bal
			if (o1.getBalance() < o2.getBalance())
				return 1;
			if (o1.getBalance() == o2.getBalance())
				return 0;
			return -1;

		}
		return retVal;
	}

}
