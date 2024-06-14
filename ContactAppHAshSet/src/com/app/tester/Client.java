package com.app.tester;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.app.contact.Contact;
import com.app.contactorderingsort.ContactSortEmail;
import com.app.contactorderingsort.ContactSortEmailAndPhone;
import com.app.contactorderingsort.ContactSortPhone;

import static com.app.utils.ContactValidation.*;
import static com.app.utils.ContactUtility.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Contact> contact=new HashSet<>();
		try(Scanner sc=new Scanner(System.in)){
			boolean exit=false;
			while(!exit) {
				try {
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
					switch(sc.nextInt()) {
					case 1:
						//create contact
						System.out.println("Enter the details:\n"
								+ "1.Country\n"
								+ "2.Phone number\n"
								+ "3.Name\n"
								+ "4.DOB\n"
								+ "5.Email\n");
						Contact cont=validateAllInput(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), contact);
						contact.add(cont);
						break;
					case 2:
						//update contact
						System.out.println("Enter the name and Dob:");
						cont=updateNumber(sc.next(), sc.next(), contact);
						System.out.print("Enter the new phone number:");
						cont.setPhoneNumber(sc.next());
						break;
					case 3:
						//Display All Contact
						displayAll(contact);
						break;
					case 4:
						//Display and Sort Contact of Specified name and DOB
						TreeSet<Contact> naturalsortedContact=new TreeSet<Contact>(contact);
						displayAll(naturalsortedContact);
						break;
					case 5:
						//Display and Sort Contact of Specified Email
						LinkedList<Contact> customeSortedContact=new LinkedList<Contact>(contact);
						Collections.sort(customeSortedContact, new ContactSortEmail());
						for(Contact c:customeSortedContact) {
							System.out.println(c);
						}
						break;
					case 6:
						//Display and Sort Contact of Specified Phone number
						customeSortedContact=new LinkedList<Contact>(contact);
						Collections.sort(customeSortedContact, new ContactSortPhone());
						for(Contact c:customeSortedContact) {
							System.out.println(c);
						}
						break;
					case 7:
						//Display and Sort Contact of Specified Phone number and Email
						customeSortedContact=new LinkedList<Contact>(contact);
						Collections.sort(customeSortedContact, new ContactSortEmailAndPhone());
						for(Contact c:customeSortedContact) {
							System.out.println(c);
						}
						break;
					case 8:
						//Delete Contact
						System.out.println("enter the name and dob:");
						cont=deleteContact(sc.next(), sc.next(), contact);
						System.out.println(cont.getName()+"'s contact is deleted!");
						contact.remove(cont);
						displayAll(contact);
						break;
					case 9:
						//Remove based on country
						System.out.println("enter the country name:");
						removeBasedOnCountry(sc.next(),contact);
						displayAll(contact);
						break;
					case 10:
						//exit
						exit=true;
						System.out.println("Exited!");
						break;
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
