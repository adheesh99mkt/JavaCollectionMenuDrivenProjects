package com.app.tester;


import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.contact.Contact;
import com.app.contact.ContactID;
import com.app.contact.CountryCode;

import static com.app.utils.ContactValidation.*;
import static com.app.utils.ContactUtility.*;
import com.app.sortingContact.*;


public class Client {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<ContactID, Contact> contact = new HashMap<>();
		try(Scanner sc =new Scanner(System.in)){
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
						//Create Contact
						System.out.println("Enter the details:\n"
								+ "1.Name\n"
								+ "2.DOB\n"
								+ "3.Country\n"
								+ "4.Phone number\n"
								+ "5.Email\n");
						ContactID contactid=new ContactID(sc.next(), parseDate(sc.next()));
						Contact cont=validateAllInput(contactid,sc.next(), sc.next(), sc.next(), contact);
						contact.put(contactid, cont);
						System.out.println("Contact created...");
						break;
					case 2:
						//Update Contact
						System.out.println("Enter the name and dob");
						cont=updateContact(new ContactID(sc.next(), parseDate(sc.next())), contact);
						System.out.println("Enter the new number");
						cont.setPhoneNum(sc.next());
						break;
					case 3:
						//Display All Contact
						display(contact);
						break;
					case 4:
						//Display and Sort Contact of Specified name and DOB
						TreeMap<ContactID,Contact> naturalsortContact=new TreeMap<>(contact);
//						contact.values()
//						.stream()
//						.sorted()
//						.forEach(c->System.out.println(c));
						display(naturalsortContact);
//						for(Contact c:naturalsortContact.values()) {
//							System.out.println(c);
//						}
						break;
					case 5:
						//Display and Sort Contact of Specified Email
						LinkedList<Contact> customeSortContact=new LinkedList<>(contact.values());
						Collections.sort(customeSortContact, new ContactEmailSort());;
						for(Contact c:customeSortContact) {
							System.out.println(c);
						}
						//anonymous
//						Collections.sort(customeSortContact, new Comparator<Contact>() {
//							@Override
//							public int compare(Contact o1, Contact o2) {
//								return o1.getEmail().compareTo(o2.getEmail());
//							}
//						});
//						for(Contact c:customeSortContact) {
//							System.out.println(c);
//						}
						break;
					case 6:
						//Display and Sort Contact of Specified Phone number
						customeSortContact=new LinkedList<>(contact.values());
						Collections.sort(customeSortContact, new ContactsortPhone());
						for(Contact c:customeSortContact) {
							System.out.println(c);
						}
						break;
					case 7:
						//Display and Sort Contact of Specified Phone number and Email
						customeSortContact=new LinkedList<>(contact.values());
						Collections.sort(customeSortContact, new ContactSortEmailPhone());
						for(Contact c:customeSortContact) {
							System.out.println(c);
						}
						break;
					case 8:
						//Delete Contact
						System.out.println("enter the name and dob:");
						cont=deleteContact(new ContactID(sc.next(), parseDate(sc.next())), contact);
						System.out.println(cont+" is deleted");
					
						break;
					case 9:
						//Remove based on country
						System.out.println("enter the country");
						ContactID contid=removeBasedCountry(sc.next(), contact);
						contact.remove(contid);
						System.out.println("Contact removed who having this country");
						display(contact);
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
