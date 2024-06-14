package com.app.tester;

import java.util.Map;
import java.util.Scanner;

import com.app.stock.Stock;

import static com.app.utils.StockUtility.*;
import static com.app.utils.StockValidation.*;
import static com.app.utils.IOutils.*;
public class Client {
	public static void main(String []args) {
		Map<String, Stock> mapStock=populateMap(populateList());
		try(Scanner sc=new Scanner(System.in)){
			boolean exit=false;
			while(!exit) {
				System.out.println("Enter the choice:\n"
						+ "1.Add New stock in the market\n"
						+ "2.View Available stocks by Company\n"
						+ "3.Purchase stocks\n"
						+ "4.Sell Stocks\n"
						+ "5.save all stock details in a binary file and exit\n"
						+ "6.display all stock\n"
						+ "7.exit\n");
				try {
					switch(sc.nextInt()) {
					case 1:
						//add new stock
						System.out.println("Enter the details of stock:\n"
								+ "stock id\n"
								+ "stock name\n"
								+ "company name\n"
								+ "price\n"
								+ "closing date\n"
								+ "quantity\n");
						Stock stock=validateAllInp(sc.next(), sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.nextInt(), mapStock);
						mapStock.put(stock.getStockId(), stock);
						System.out.println("stock added...");
						break;
					case 2:
						//view available stock by a company
						System.out.println("enter the company name");
						System.out.println(getStockOfCompany(sc.next(), mapStock));
						break;
					case 3:
						//purchase stock
						System.out.println("Enter the stock id to be purchased");
						stock=getStockById(sc.next(), mapStock);
						System.out.println("Enter the quantity");
						System.out.println(purchaseStock(stock, sc.nextInt()));
						break;
					case 4:
						//sell stocks
						System.out.println("Enter the stock id to sale");
						stock=getStockById(sc.next(), mapStock);
						System.out.println("Enter the quantity");
						System.out.println(sellStock(stock, sc.nextInt()));
						break;
					case 5:
						//save to binary file and exit
						System.out.println("Enter the filename");
						writeDetails(mapStock,sc.next());
						System.out.println("details saved....");
						exit=true;
						break;
					case 6:
						//all stocks
						mapStock.values().forEach(s->System.out.println(s));
						break;
					case 7:
						//exit
						exit=true;
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
