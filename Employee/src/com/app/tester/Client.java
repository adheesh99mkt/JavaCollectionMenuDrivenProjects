package com.app.tester;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import com.app.employee.EmpType;
import com.app.employee.Employee;
import com.app.sort.CustomeSortJoinDate;

import static com.app.utils.validateEmployee.*;
import static com.app.utils.EmpUtility.*;

public class Client {

	public static void main(String[] args) {
		HashMap<String, Employee> empMap=new HashMap<>();
		try(Scanner sc=new Scanner(System.in)){
			boolean exit=false;
			while(!exit) {
				System.out.println("Enter the choice\n"
						+ "1.Add full time employee\n"
						+ "2.Add part time employee\n"
						+ "3.Delete an employee by Emp Id\n"
						+ "4.Search employee details by Aadhaar number\n"
						+ "5.Display all employee details\n"
						+ "6.Display all employee details sorted by date of joining\n"
						+ "7.Exit\n");
				try {
					switch(sc.nextInt()) {
					case 1:
						//add fte
						/*String name, LocalDate dateOfJoin, String phone, 
						 * String aadhar,EmpType empType,
							double salary.*/
						System.out.println("Enter the details\n"
								+ "Name\nDate of joining\nPhone Number,\nAadhaar number\nMonthly salary\n");
						Employee emp=validateAllInp(sc.next(),sc.next(),sc.next(),sc.next(),EmpType.FTE,sc.nextDouble(),empMap);
						empMap.put(emp.getAadhar(), emp);
						System.out.println("FTE added...");
						break;
					case 2:
						//add pte
						System.out.println("Enter the details\n"
								+ "Name\nDate of joining\nPhone Number,\nAadhaar number\nMonthly salary\n");
						emp=validateAllInp(sc.next(),sc.next(),sc.next(),sc.next(),EmpType.PTE,sc.nextDouble(),empMap);
						empMap.put(emp.getAadhar(), emp);
						System.out.println("PTE added...");
						break;
					case 3:
						//delete by empid
						System.out.println("Enter the empid");
						System.out.println(removeEmployee(sc.nextInt(), empMap)); 
						break;
					case 4:
						//search emp by aadhar
						System.out.println("Enter the aadhar number");
						System.out.println(getEmpByAadhar(sc.next(), empMap));
						break;
					case 5:
						//display all
						empMap.values().forEach(e->System.out.println(e));
						break;
					case 6:
						//display all by sort with date of join
						LinkedList<Employee> list=new LinkedList<Employee>(empMap.values());
						Collections.sort(list, new CustomeSortJoinDate());
						System.out.println("Sorted emp details");
						for (Employee e:list) {
							System.out.println(e);
						}
						break;
					case 7:
						exit=true;
						System.out.println("exited");
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
