package com.app.tester;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.app.customeOrdering.CustSortDobLname;
import com.app.customer.Customer;
import static com.app.validation.CustomerValidation.*;
import static com.app.validation.CustomerUtils.*;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Customer> customer=new ArrayList<Customer>();
		boolean exit=false;
		try(Scanner sc=new Scanner(System.in)){
			while(!exit) {
				try {
					System.out.println("Enter the choice\n"
							+ "1.Sign Up\n"
							+ "2.Sign In\n"
							+ "3.Change Password\n"
							+ "4.Unsubscribe\n"
							+ "5.Display All\n"
							+ "6.sort by email id(asc)\n"
							+ "7.sort by dob and last name using custom ordering\n"
							+ "8.sort by dob and last name using anonymous inner class\n"
							+ "9.remove using specified date\n"
							+ "0.Exit");
					switch(sc.nextInt()) {
					case 1:
						//signup
						System.out.println("email\n"
								+ "fname\n"
								+ "lname\n"
								+ "password\n"
								+ "regAmount\n"
								+ "dob\n"
								+ "plan)");
						customer.add(validateAllInput(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),customer));
						System.out.println("User created...");
						break;
					case 2:
						//signin
						System.out.println("Enter the email and password");
						Customer cust=signIn(sc.next(), sc.next(), customer);
						System.out.println("Logged In..Hello "+cust.getFname()+" "+cust.getLname());
						break;
					case 3:
						//change password
						System.out.println("enter the email and old password");
						cust=signIn(sc.next(), sc.next(), customer);
						System.out.println("Enter the new password");
						changePassword(cust, sc.next());
						System.out.println("Password updated!");
						break;
					case 4:
						//Unsubscribe
						System.out.println("enter the email and password");
						removeUser(sc.next(), sc.next(), customer);
						System.out.println("Customer removed...");
						break;
					case 5:
						//Display all
						customer.forEach(l->System.out.println(l));
						break;
					case 6:
						//sort by email id(asc)
						Collections.sort(customer);
						customer.forEach(l->System.out.println(l));
						break;
					case 7:
						//sort by dob and last name using custom ordering
						Collections.sort(customer, new CustSortDobLname());
						customer.forEach(l->System.out.println(l));
						break;
					case 8:
						//sort by dob and last name using anonymous inner class
						Collections.sort(customer, new Comparator<Customer>() {							public int compare(Customer o1, Customer o2) {
								int val=o1.getDob().compareTo(o2.getDob());
								if(val==0) {
									return o1.getLname().compareTo(o2.getLname());
								}
								return val;
							};
						});
						
						break;
					case 9:
						//remove using specified date
						System.out.println("enter the date");
						removeUsingSpecDate(sc.next(), customer);
						System.out.println("customers after removal");
						customer.forEach(l->System.out.println(l));
						break;
					case 0:
						exit=true;
						System.out.println("Exited!");
						break;
					}
					
				}
				catch(Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
			
		}
	}

}
