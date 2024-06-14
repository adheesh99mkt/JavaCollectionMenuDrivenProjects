package com.app.tester;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import com.app.cricketer.Cricketer;
import static com.app.utils.ValidateCricketer.*;
import static com.app.utils.Utility.*;

import com.app.sort.RatingSort;
import com.app.sort.RatingSort.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Cricketer> cricketrMap=new HashMap<String, Cricketer>();
		try(Scanner sc=new Scanner(System.in)){
			boolean exit=false;
			while(!exit) {
				System.out.println("Enter the choice:\n"+
						"1.Accept minimum 5 Cricketers in the collection.\n"+

						"2.Modify Cricketer's rating\n"+

						"3.Search Cricketer by name\n"+

						"4. Display all Cricketers added in collection.\n"+

						"5.Display All Cricketers in sorted form by rating.\n");

				try {
					switch (sc.nextInt()) {
					case 1:
						//accept cricketer
						//email,name,phone,age,rating
						System.out.println("1.Email\n"
								+ "2.Name\n"
								+ "3.Phone\n"
								+ "4.Age\n"
								+ "5.Rating\n");
						Cricketer cricketer=validateAllInput(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextInt(), cricketrMap);
						cricketrMap.put(cricketer.getEmail(), cricketer);
						System.out.println("Cricker added................");
						break;
					case 2:
						//modify rating
						System.out.println("Enter the email");
						cricketer=validateEmail(sc.next(), cricketrMap);
						System.out.println("Enter the new rating");
						cricketer.setRating(sc.nextInt());
						System.out.println("rating modified");
						break;
					case 3:
						//search by name
						System.out.println("Enter the name");
						System.out.println(searchByName(sc.next(), cricketrMap));
						break;
					case 4:
						//display all
						cricketrMap.values().forEach(l->System.out.println(l));
						break;
					case 5:
						//sort by rating
						LinkedList<Cricketer> customsort=new LinkedList<>(cricketrMap.values());
						Collections.sort(customsort, new RatingSort());
						customsort.forEach(l->System.out.println(l));
						
						break;
					case 6:
						//exit
						exit=true;
						System.out.println("Exited");
						break;
					}
					
				}
				catch (Exception e) {
					System.out.println(e);
					sc.nextLine();
				}
			}
			
		}

	}

}
