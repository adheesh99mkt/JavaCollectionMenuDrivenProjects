
package com.app.Client;

import static com.app.customerValidate.CustValidate.*;
import static com.app.customerValidate.CustomerUtility.*;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.custOrdering.CustDobLastnameSort;
import com.app.custOrdering.CustDobLastnameSort.*;
import com.app.customer.Customer;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Customer> customer=new HashMap<>();
		try(Scanner sc=new Scanner(System.in)) {
			boolean exit=false;
			while(!exit) {
				try {
					System.out.println("Enter the choice:");
					System.out.println("1.Sign Up\n2.Sign In\n3.Change Password\n4.Unsubscribe\n5.Display All\n6.sort by email id(asc)\n"
							+ "7.sort by dob and last name using custom ordering\n8.sort by dob and last name using anonymous inner class\n9.remove using specified date\n0.Exit");
					switch(sc.nextInt()) {
					case 1:
						System.out.println("Enter the Customer details:");
						System.out.println(
								  "1.First Name\n"
								+ "2.Last Name\n"
								+ "3.Email\n"
								+ "4.Password\n"
								+ "5.Registration Amount\n"
								+ "6.DOB\n"
								+ "7.Service Plan\n"
								);
						Customer cust=validateAllInput(sc.next(), sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(), sc.next(), customer);
						customer.put(cust.getEmail(),cust);
						break;
					case 2:
						System.out.println("Enter the email and password:");
						cust=customerSignIn(sc.next(),sc.next(), customer);
						System.out.println("user "+cust.getFname()+" is successfully logged in...");
						break;
						
					case 3:
						System.out.print("Enter the email and old password:");
						cust=changePassword(sc.next(), sc.next(),customer);
						System.out.print("Enter the New password:");
						String newpass=sc.next();
						validatePassword(newpass);
						cust.setPassword(newpass);
						System.out.println(cust.getFname()+"'s Password changed...");
						break;
					case 4:
						System.out.println("Enter the email and password:");
						System.out.println(deleteCustomer(sc.next(),sc.next(), customer));
						break;
					case 5:
						display(customer);
						break;
					case 6:
						TreeMap<String, Customer> naturalSort=new TreeMap<>(customer);
						System.out.println("sorted as per email id:");
						for(Customer c:naturalSort.values()) {
							System.out.println(c);
						}
						break;
					case 7:
						LinkedList<Customer> custSort=new LinkedList<>(customer.values());
						Collections.sort(custSort, new CustDobLastnameSort());
						for(Customer c:custSort) {
							System.out.println(c);
						}
						break;
					case 8:
						//anonymous class
						custSort=new LinkedList<>(customer.values());
						Collections.sort(custSort, new Comparator<Customer>() {
							public int compare(Customer c1,Customer c2) {
								int val=c1.getDob().compareTo(c2.getDob());
								if(val==0) {
									return c1.getLname().compareTo(c2.getLname());
								}
								return val;
							}
						});
						for(Customer c:custSort) {
							System.out.println(c);
						}
						break;
					case 9:
						System.out.println("Enter the plan and date:");
						removePlanAfterSpecifiedDate(sc.next(), sc.next(), customer);
						System.out.println("Customers after removal..");
						display(customer);
						break;
					default:
						exit=true;
					}
				}
				catch(Exception e) {
					System.out.println(e);
					sc.nextLine();
				}
			}
			
		}

	}

}
