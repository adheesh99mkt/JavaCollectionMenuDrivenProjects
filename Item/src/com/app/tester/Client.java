package com.app.tester;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.app.item.Item;
import com.app.sort.iItemPriceSort;

import static com.app.utils.IOutils.*;
import static com.app.utils.ItemUtils.*;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Item>list=populateList();
		try(Scanner sc=new Scanner(System.in)){
			System.out.println("Enter the choice:\n"
					+ "1. Sort these details as per Item code. Store them in binary file\n"
					+ "2.Sort these details as per Item price. Store them in binary file\n");
			switch(sc.nextInt()) {
			case 1:
				Collections.sort(list);
				System.out.println("Enter the filename");
				writeDetails(list, sc.next());
				System.out.println("data stored...");
				break;
			case 2:
				Collections.sort(list,new iItemPriceSort());
				System.out.println("Enter the filename");
				writeDetails(list, sc.next());
				System.out.println("data stored...");
				break;
			}
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
