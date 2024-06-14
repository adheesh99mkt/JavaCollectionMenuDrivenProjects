package com.app.stock;

import java.io.Serializable;
import java.time.LocalDate;

public class Stock implements Serializable{
//stock id (unique : string), stock name (string), 
//company name(string) , price (double), closing date (Date) , quantity (int)
	private String stockId;
	private String stockName;
	private String companyName;
	private double price;
	private LocalDate closeDate;
	private int quantity;
	public static int counter=0;
	private int code;
	public Stock(String stockId, String stockName, String companyName, double price, LocalDate closeDate,
			int quantity) {
		super();
		counter++;
		this.code=counter;
		this.stockId = stockId;
		this.stockName = stockName;
		this.companyName = companyName;
		this.price = price;
		this.closeDate = closeDate;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", stockName=" + stockName + ", companyName=" + companyName + ", price="
				+ price + ", closeDate=" + closeDate + ", quantity=" + quantity + "]";
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(LocalDate closeDate) {
		this.closeDate = closeDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStockId() {
		return stockId;
	}
	@Override
		public boolean equals(Object obj) {
			if(obj instanceof Stock) {
				Stock stock=(Stock)obj;
				return this.stockId.equals(stock.stockId);
			}
			return false;
		}
	@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return this.code;
		}
	
	
}
