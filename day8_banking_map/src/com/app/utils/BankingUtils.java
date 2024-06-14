
package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.banking.AcType;
import com.app.banking.BankAccount;
import com.app.custom_exceptions.BankingException;

public class BankingUtils {
//add a static method to return a/c details or throw exc
	public static BankAccount findAccountDetailsByAcctNo(int accNo, Map<Integer, BankAccount> accts)
			throws BankingException {
		BankAccount acct = accts.get(accNo);// auto boxing --> up casting
		if (acct == null)
			throw new BankingException("Invalid a/c no !!!!");
		return acct;
	}

	// add a static method to return the Map populated with bank accounts
	public static Map<Integer, BankAccount> populateBankAccounts() {
		BankAccount a1 = new BankAccount(101, "a1", "b1", AcType.SAVINGS, LocalDate.parse("1991-10-27"),
				LocalDate.parse("2011-12-17"), 15000);
		BankAccount a2 = new BankAccount(10, "a2", "b2", AcType.CURRENT, LocalDate.parse("1991-11-18"),
				LocalDate.parse("2012-12-17"), 8000);
		BankAccount a3 = new BankAccount(45, "a3", "b3", AcType.SAVINGS, LocalDate.parse("1991-10-27"),
				LocalDate.parse("2013-12-17"), 18000);
		BankAccount a4 = new BankAccount(56, "a4", "b4", AcType.FD, LocalDate.parse("1992-01-17"),
				LocalDate.parse("2020-12-17"), 150000);
		BankAccount a5 = new BankAccount(25, "a5", "b5", AcType.LOAN, LocalDate.parse("1991-10-27"),
				LocalDate.parse("2019-12-17"), 25000);
		BankAccount a6 = new BankAccount(40, "a6", "b6", AcType.SAVINGS, LocalDate.parse("1991-10-27"),
				LocalDate.parse("2018-12-17"), 23000);
		BankAccount a7 = new BankAccount(10, "a7", "b7", AcType.SAVINGS, LocalDate.parse("1991-03-17"),
				LocalDate.parse("2018-12-11"), 35000);
		BankAccount[] accts = { a1, a2, a3, a4, a5, a6, a7 };
		Map<Integer, BankAccount> map = new HashMap<>();
		for (BankAccount a : accts)
			System.out.println(map.put(a.getAcctNo(), a));
		return map;
	}
	// add public static method for transferring funds

	public static String transferFunds(int srcAcNo, int destAcNo, double amount, Map<Integer, BankAccount> list)
			throws BankingException {
		// 1. get src acct from it's acc no
		BankAccount src = findAccountDetailsByAcctNo(srcAcNo, list);
		// 2. get dest acct from it's acc no
		BankAccount dest = findAccountDetailsByAcctNo(destAcNo, list);
		// 3 call transferFunds method
		src.transferFunds(dest, amount);
		return "Funds transferred....";
	}

	// close account
	public static String closeAccount(int accNo, Map<Integer, BankAccount> accounts) throws BankingException {
		BankAccount removedAcct=accounts.remove(accNo);
		if(removedAcct == null)
			throw new BankingException("A/C can't be closed - invalid a/c no!!!!!!");
		return "Closed - "+removedAcct;
	}
//display a/c holders name for the specified ac type
	public static void displayByAcType(String acType, 
			Map<Integer,BankAccount> accounts) {
		// 1. parse string --> enum
		AcType selectedType = BankingValidations.
				parseAndValidateAcType(acType);
		// => parsing successful
		// 2. Since the search criteria -- ac type : value based criteria
		//there is no direct api in the map , convert Map --> Collection view(keySet / values/entrySet) : values()
		for (BankAccount a : accounts.values())
			if (a.getAcType() == selectedType)
				System.out.println(a.getFirstName() + " " + a.getLastName());

	}
}
