package com.app.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.custome_exception.StockCustomeExc;
import com.app.stock.Stock;

public class StockUtility {
	public static List<Stock> populateList(){
		//stock id (unique : string), stock name (string), 
		//company name(string) , price (double), closing date (Date) , quantity (int)
		List<Stock> stockList=new ArrayList<Stock>(
				Arrays.asList(new Stock("123a", "Tatasteel", "Tata",1000 ,LocalDate.parse("2024-09-01"), 10),
						new Stock("234b", "Infosysshare", "Infosys",2000 ,LocalDate.parse("2024-10-07"), 20),
						new Stock("345c", "ITCshare", "ITC",3000 ,LocalDate.parse("2024-08-09"), 5),
						new Stock("456d", "Relianceshare", "Reliance",4000 ,LocalDate.parse("2024-05-23"), 13),
						new Stock("567e", "Bajajmotors", "Bajaj",5000 ,LocalDate.parse("2024-12-07"), 15)
				));
		return stockList;
	}
	public static HashMap<String, Stock> populateMap(List<Stock> stockList){
		HashMap<String, Stock> stockMap=new HashMap<String, Stock>();
		stockList.forEach(s->stockMap.put(s.getStockId(), s));
		return stockMap;
	}
	public static String purchaseStock(Stock stock,int quantity) throws StockCustomeExc {
		if(stock.getQuantity()>=quantity) {
			stock.setQuantity(stock.getQuantity()-quantity);
			return "Stock purchased from platform successfully";
		}
		throw new StockCustomeExc("Insufficient stock quantity");
	}
	public static String sellStock(Stock stock,int quantity) {
		
		stock.setQuantity(quantity+stock.getQuantity());
		return "Stock selled to platform successfully";
			
		
	}
	public static Stock getStockOfCompany(String company,Map<String, Stock>mapStock) throws StockCustomeExc {
		for(Stock st:mapStock.values()) {
			if(st.getCompanyName().equalsIgnoreCase(company)) {
				return st;
			}
		}
		throw new StockCustomeExc("This company stock is not available");
	}
}
