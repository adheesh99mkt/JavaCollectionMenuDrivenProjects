package com.app.utils;

import java.time.LocalDate;
import java.util.Map;

import com.app.banking.AcType;
import com.app.banking.BankAccount;
import com.app.custom_exceptions.BankingException;

public class BankingValidations {

//add public static method to validate for min bal
	public static void validateBalance(AcType type, double balance) throws BankingException {
		if (balance < type.getMinBalance())
			throw new BankingException("Insufficient Balance !!!!!");
		System.out.println("valid balance....");
	}

	// add public static method to validate all i/ps
	public static BankAccount validateInputs(int acctNo, String fName, String lastName, String acType, String dob,
			String creationDate, double balance, Map<Integer,BankAccount> accounts) throws BankingException {
		checkForDup(acctNo, accounts);
		AcType type = parseAndValidateAcType(acType);
		LocalDate birthDate = parseDate(dob);
		LocalDate crDate = parseDate(creationDate);
		validateBalance(type, balance);
		// => all i/ps are valid
		return new BankAccount(acctNo, fName, lastName, type, birthDate, crDate, balance);
	}

	// add a static method for parsing n validating ac type
	public static AcType parseAndValidateAcType(String acType) {
		return AcType.valueOf(acType.toUpperCase());
	}

	// add a static method for parsing string --> LocalDate
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}

	// add a static method for checking dup accts (PK / UID -- acct no)
	public static void checkForDup(int acctNo, 
			Map<Integer,BankAccount> accts) throws BankingException {
		if (accts.containsKey(acctNo))
			throw new BankingException("Dup account no !!!!!");
	}

}
