package com.app.tester;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.app.customer.Customer;

public class Client {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in)){
			boolean exit=false;
			Set<Customer> customer=new HashSet<Customer>();
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
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 7:
					case 8:
					case 9:
					case 0:
						exit=true;
						System.out.println("Exited");
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
