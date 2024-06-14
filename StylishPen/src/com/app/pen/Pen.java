package com.app.pen;

import java.time.LocalDate;

public class Pen {
	private int id;
	private PenBrand brand;
	private PenColor color;
	private PenInkColor penColor;
	private PenMaterial material;
	private int stock;
	private LocalDate updateDate;
	
	private LocalDate listDate;
	private double price;
	private double discount;
	
	private static int counter=0;
	public Pen( PenBrand brand, PenColor color, PenInkColor penColor, PenMaterial material, int stock,
			LocalDate updateDate, LocalDate listDate, double price, double discount) {
		
		counter++;
		this.id = counter;
		this.brand = brand;
		this.color = color;
		this.penColor = penColor;
		this.material = material;
		this.stock = stock;
		this.updateDate = updateDate;
		this.listDate = listDate;
		this.price = price;
		this.discount = discount;
	}
	
	

	@Override
	public String toString() {
		return "Pen [id=" + id + ", brand=" + brand + ", color=" + color + ", penColor=" + penColor + ", material="
				+ material + ", stock=" + stock + ", updateDate=" + updateDate + ", listDate=" + listDate + ", price="
				+ price + ", discount=" + discount + "]";
	}
	public Pen(int id) {
		this.id=id;
	}
	public PenBrand getBrand() {
		return brand;
	}
	public void setBrand(PenBrand brand) {
		this.brand = brand;
	}
	public PenColor getColor() {
		return color;
	}
	public void setColor(PenColor color) {
		this.color = color;
	}
	public PenInkColor getPenColor() {
		return penColor;
	}
	public void setPenColor(PenInkColor penColor) {
		this.penColor = penColor;
	}
	public PenMaterial getMaterial() {
		return material;
	}
	public void setMaterial(PenMaterial material) {
		this.material = material;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public LocalDate getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}
	public LocalDate getListDate() {
		return listDate;
	}
	public void setListDate(LocalDate listDate) {
		this.listDate = listDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		Pen.counter = counter;
	}
	public int getId() {
		return id;
	}
	public LocalDate updateTheDate() {
		return this.updateDate=LocalDate.now();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Pen) {
			Pen pen=(Pen)obj;
			return this.getId()==pen.getId();
			
		}
		return false;
		
	}

	
	
	
}
