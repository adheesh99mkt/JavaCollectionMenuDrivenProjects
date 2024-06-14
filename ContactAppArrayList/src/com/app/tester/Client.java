package com.app.tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.app.contact.Contact;
import com.app.customcontactordering.ContactSortEmail;
import com.app.customcontactordering.ContactSortEmailandPhone;
import com.app.customcontactordering.ContactSortPhoneNumber;

import static com.app.utils.ContactUtility.*;
import static com.app.utils.ValidateContact.*;

public class Client {

	public static void main(String[] args) {
		List<Contact> contact=new ArrayList<Contact>();
		try(Scanner sc=new Scanner(System.in)){
			boolean exit=false;
			while(!exit) {
				System.out.println("Enter the choice:\n"
						+ "1.Create Contact\n"
						+ "2.Update Contact\n"
						+ "3.Display All Contact\n"
						+ "4.Display and Sort Contact of Specified name and DOB\n"
						+ "5.Display and Sort Contact of Specified Email\n"
						+ "6.Display and Sort Contact of Specified Phone number\n"
						+ "7.Display and Sort Contact of Specified Phone number and Email\n"
						+ "8.Delete Contact\n"
						+ "9.Remove based on country\n"
						+ "10.Exit");
				try {
					int choice=sc.nextInt();
					switch(choice) {
					case 1:
						//create contact
						System.out.println("Enter the details:\n"
								+ "1.Country\n"
								+ "2.Phone number\n"
								+ "3.Name\n"
								+ "4.DOB\n"
								+ "5.Email\n");
						Contact cont=validateAllInputs(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), contact);
						contact.add(cont);
						System.out.println("Contact added successfully...");
						break;
					case 2:
						//update contact
						System.out.println("Enter the name and dob:");
						cont=updateNumber(sc.next(), sc.next(),contact);
						System.out.println("Enter the new Number:");
						String num=sc.next();
						validatePhoneNumber(num);
						cont.setPhoneNumber(num);
						System.out.println("Number updated successfully...");
						break;
					case 3:
						//display all
						displayAllContact(contact);
						break;
					case 4:
						//display and sort using name and dob
						Collections.sort(contact);
						displayAllContact(contact);
						break;
					case 5:
						//display and sort using email
						Collections.sort(contact, new ContactSortEmail());
						displayAllContact(contact);
						break;
					case 6:
						//display and sort using phone number
						Collections.sort(contact, new ContactSortPhoneNumber());
						displayAllContact(contact);
						break;
					case 7:
						//display and sort using number and dob
						Collections.sort(contact, new ContactSortEmailandPhone());
						displayAllContact(contact);
						break;
					case 8:
						//delete contact
						System.out.println("Enter the name and dob:");
						int index=deleteContact(sc.next(), sc.next(), contact);
						contact.remove(index);
						displayAllContact(contact);
						break;
					case 9:
						System.out.println("Enter the country name:");
						removeBasedOnCountry(sc.next(), contact);
						displayAllContact(contact);
						break;
					case 10:
						//exit
						exit=true;
						break;
					}
					
				}catch(Exception e) {
					System.out.println(e);
					sc.nextLine();
				}
				
			}
		}

	}

}
