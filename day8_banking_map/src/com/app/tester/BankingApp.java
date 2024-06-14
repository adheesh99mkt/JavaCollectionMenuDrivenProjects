package com.app.tester;

import static com.app.utils.BankingUtils.findAccountDetailsByAcctNo;
import static com.app.utils.BankingUtils.populateBankAccounts;
import static com.app.utils.BankingValidations.validateInputs;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.banking.BankAccount;
import com.app.custom_ordering.BankAccountBalanceComparator;
import com.app.utils.BankingUtils;

public class BankingApp {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// start up : init phase
			boolean exit = false;
			// init D.S -- list (ArrayList)
			Map<Integer, BankAccount> accounts = populateBankAccounts();// size : 0 , init capa :10
			while (!exit) {
				// clnt servicing phase
				System.out.println(
						"Options : 1. Create A/C \n" + "2. Display All Accounts \n" + "3. Display account summary \n"
								+ "4. Withdraw Funds \n" + "5. Transfer Funds \n" + "6. Close A/C \n"
								+ "7. Display A/Cs  by ac type  \n" + "8. Display A/Cs  sorted by ac nos (asc)  \n"
								+ "9. Display A/Cs  sorted by ac balance (asc)  \n"
								+ "10. Display A/Cs  sorted by DoB  \n" + "0. Exit ");
				System.out.println("Choose an option");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter a/c details -  acctNo,  firstName,"

								+ " lastName,  acType,  dob, creationDate, balance");
						BankAccount acct = validateInputs(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.next(), sc.nextDouble(), accounts);
						// add acct ref to the List
						accounts.put(acct.getAcctNo(), acct);
						System.out.println("A/c created !");
						break;
					case 2: // display all account details
						System.out.println("All account details -");
						for (BankAccount a : accounts.values())// a=accounts[0],.....
							System.out.println(a);
						break;
					case 3:
						System.out.println("Enter acct no");
						BankAccount account = findAccountDetailsByAcctNo(sc.nextInt(), accounts);
						System.out.println(account);
						break;
					case 4: // withdraw
						System.out.println("Enter acct no n amount");
						account = findAccountDetailsByAcctNo(sc.nextInt(), accounts);
						System.out.println("Updated bal " + account.withdraw(sc.nextDouble()));
						break;
					case 5: // funds transfer
						System.out.println("src acct no , dest acct no , amount");
						System.out.println(
								BankingUtils.transferFunds(sc.nextInt(), sc.nextInt(), sc.nextDouble(), accounts));
						break;

					case 6: // close a/c (delete a/c details)
						System.out.println("Enter acct no to close the a/c");
						System.out.println(BankingUtils.closeAccount(sc.nextInt(), accounts));
						break;
					case 7:
						// display account holder's names :
						// having specific type of acct
						System.out.println("Enter ac type (option available only to Bank Staff login)");
						BankingUtils.displayByAcType(sc.next(), accounts);
						break;
					case 8:// sort acct details as per asc order of acct nos (Natural Ordering)
							// since sroting criteria : acct no --key based --TreeMap(Map map)
							// While sorting --TimSort -- invokes --Integer's compareTo
						TreeMap<Integer, BankAccount> sortedAcctMap = new TreeMap<>(accounts);
						System.out.println("Sorted accts as per asc acct nos");
						for (BankAccount a : sortedAcctMap.values())
							System.out.println(a);
						break;
					case 9:// sort acct details as per asc order of bal (Custom ordering)
						//sorting as per key based or value based ? bal --value
						//map --> Collection<BankAccount> : values()
						//Collection --> LinkedList(any List)
						LinkedList<BankAccount> list=new LinkedList<>(accounts.values());
						Collections.sort(list, 
								new BankAccountBalanceComparator());
						System.out.println("sorted accts as per balance");
						for(BankAccount a : list)
							System.out.println(a);
						break;
//					case 10: // sort acct details as per asc order of dob
//						Collections.sort(accounts, new BankAccountDobComparator());
//						break;
//					case 11: // sort acct details as per asc order of dob n balance(desc)
//						Collections.sort(accounts, new BankAccountDobBalanceComparator());
//						break;
//					case 12: // sort acct details as per desc order of dob of a/c holder , using anonymous
//								// inner class
//						// new Comparator<BankAccount>() => instance of the ano inner cls imple
//						// Comaprator
//						Collections.sort(accounts, new Comparator<BankAccount>() {
//
//							@Override
//							public int compare(BankAccount o1, BankAccount o2) {
//								// TODO Auto-generated method stub
//								return o2.getDob().compareTo(o1.getDob());
//							}
//
//						});
//						break;

					case 0:
						exit = true;
						break;
					}
				} catch (Exception e) {
					System.out.println(e);
					// read off all the pending tokens from the Scanner's buffer till new line
					sc.nextLine();
				}

			}
		} // JVM : sc.close()

		System.out.println("main over...");

	}

}
