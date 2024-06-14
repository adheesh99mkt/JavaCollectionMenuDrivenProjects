package com.app.utils;

import java.time.LocalDate;
import java.util.Map;

import com.app.custome_exception.StockCustomeExc;
import com.app.stock.Stock;

public class StockValidation {
	public static void validateStockId(String stockId,Map<String, Stock>mapStock) throws StockCustomeExc {
		Stock stock=mapStock.get(stockId);
		if(stock!=null) {
				throw new StockCustomeExc("Stock is already added");
		}
	}
	public static Stock getStockById(String stockId,Map<String, Stock>mapStock) throws StockCustomeExc {
		Stock stock=mapStock.get(stockId);
		if(stock==null) {
			throw new StockCustomeExc("Stock is already added");
		}
		return stock;
	}
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}
	public static void dateValidation(LocalDate date) throws StockCustomeExc {
		if(date.isBefore(LocalDate.now())) {
			throw new StockCustomeExc("Given date is a past date!");
		}
	}
	public static Stock validateAllInp(String stockId, String stockName, String companyName, double price, String closeDate,
			int quantity,Map<String, Stock>mapStock) throws StockCustomeExc {
		validateStockId(stockId, mapStock);
		LocalDate date=parseDate(closeDate);
		dateValidation(date);
		return new Stock(stockId, stockName, companyName, price, date, quantity);
		
	}
}
