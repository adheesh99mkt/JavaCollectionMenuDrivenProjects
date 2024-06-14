package com.app.item;

import java.io.Serializable;
import java.time.LocalDate;

public class Item implements Serializable,Comparable<Item> {
	private String itemCode;
	private String description;
	private double price;
	private LocalDate shipmentDate;
	/**
	 * 
	 */
	private static final long serialVersionUID = -7239068490912673790L;

	
	public Item(String itemCode, String description, double price, LocalDate shipmentDate) {
		super();
		this.itemCode = itemCode;
		this.description = description;
		this.price = price;
		this.shipmentDate = shipmentDate;
	}


	
	
	
	public String getItemCode() {
		return itemCode;
	}


	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public LocalDate getShipmentDate() {
		return shipmentDate;
	}


	public void setShipmentDate(LocalDate shipmentDate) {
		this.shipmentDate = shipmentDate;
	}





	@Override
	public String toString() {
		return "Item [itemCode=" + itemCode + ", description=" + description + ", price=" + price + ", shipmentDate="
				+ shipmentDate + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Item) {
			Item item=(Item)obj;
			return this.itemCode.equals(item.itemCode);
		}
		return false;
	}





	@Override
	public int compareTo(Item o) {
		return this.itemCode.compareTo(o.itemCode);
	}
	
	
}
