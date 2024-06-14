package com.app.tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.app.pen.Pen;
import com.app.pen.PenBrand;
import com.app.pen.PenColor;
import com.app.pen.PenInkColor;
import com.app.pen.PenMaterial;
import static com.app.utils.PenUtility.*;

import static com.app.utils.ValidatePen.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Pen> penList=new ArrayList<>();
//		HashMap<Integer,Pen> penMap=new HashMap<>();
		try(Scanner sc=new Scanner(System.in)){
			boolean exit=false;
			while(!exit) {
				System.out.println("Enter your choice:\n"
						+ "1. Add new Pen\r\n"
						+ "2. Update stock of aPen\r\n"
						+ "3. Set discount of 20% for all the pens which are not at all sold in last 3 months\r\n"
						+ "4. Remove Pens which arenever sold once listed in 9 months\n"
						+ "5. display all pen");
				
				try {
				switch (sc.nextInt()) {
				case 1:
					//1. Add new Pen
					System.out.println("give the details"+
							  " brand\n"
							+ "	color\n"
							+ "	penColorr\n"
							+ "	material\n"
							+ "	stock\n"
							+ "	updateDate\n"
							+ "	listDate\n"
							+ "	price\n"
							+ "	discount\n"
							+ "");
					
					
					Pen pen=validateInput(sc.next(), sc.next(), sc.next(),  sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.nextDouble(), sc.nextDouble());
					penList.add(pen);
					System.out.println("Pen added");
					break;
				case 2:
					//2. Update stock of aPen
					System.out.println("Enter the Pen Id");
					
					Pen pen1=validatePenDetails(sc.nextInt(), penList);
					System.out.println("Enter the new Stock:");
					System.out.println(updatePenStock(pen1,sc.nextInt(),penList));
					break;
				case 3:
					//3.Set discount of 20% for all the pens which 
					//are not at all sold in last 3 months
					//PenBrand brand, PenColor color, PenInkColor penColor, PenMaterial material)
					addDiscount( penList);
					for (Pen pen2 : penList) {
						System.out.println(pen2);
					}
					
					break;
				case 4:
					//remove
					removePen(penList);
					for (Pen pen2 : penList) {
						System.out.println(pen2);
					}
					
					break;
				case 5:
					//display
					for (Pen pen2 : penList) {
						System.out.println(pen2);
					}

				default:
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
