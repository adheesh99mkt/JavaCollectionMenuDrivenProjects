package com.app.tester;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.app.utils.IOUtils.*;
import com.app.statement.Statement;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner sc=new Scanner(System.in)){
			List<Statement> statement=new ArrayList<Statement>();
			System.out.println("enter the filename:");
			statement=readDetails(sc.nextLine(),statement);
			statement.forEach(s->System.out.println(s));
			boolean exit=false;
			while(!exit) {
				System.out.println("file stored into list...");
				System.out.println("enter the choice:\n"
						+ "1.Sum of all deposits \n"
						+ "2.Max deposit amount\n"
						+ "3.Shopping expenses\n"
						+ "4.Date on which max amount withdrawn\n"
						+ "5.exit");
				try {
					switch(sc.nextInt()) {
					case 1:
						System.out.println("Sum of all deposits = "+sumOfAllDeposite(statement));
						break;
					case 2:
						System.out.println("Max deposit amount = "+maxDepositeAmount(statement));
						break;
					case 3:
						System.out.println("Shopping expenses = "+shoppingExpense(statement));
						break;
					case 4:
						System.out.println("Date on which max amount withdrawn = "+maxWithdrawDate(statement));
						break;
					case 5:
						exit=true;
						break;
					}
					
				}
				catch (Exception e) {
					System.out.println(e);
					sc.nextLine();
				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
