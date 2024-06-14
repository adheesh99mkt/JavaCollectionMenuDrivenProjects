package com.app.store;

public class Pet {
	// petId, name, category, unitPrice, stocks
	private int petId;
	private String name;
	private PetCategory category;
	private double unitPerice;
	private int stock;
	
	private static int counter=0;

	public Pet(String name, PetCategory category, double unitPerice, int stock) {
		super();
		counter++;
		this.petId=counter;
		this.name = name;
		this.category = category;
		this.unitPerice = unitPerice;
		this.stock = stock;
	}

	public Pet(int petId) {
		super();
		this.petId = petId;
	}

	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", name=" + name + ", category=" + category + ", unitPerice=" + unitPerice
				+ ", stock=" + stock + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PetCategory getCategory() {
		return category;
	}

	public void setCategory(PetCategory category) {
		this.category = category;
	}

	public double getUnitPerice() {
		return unitPerice;
	}

	public void setUnitPerice(double unitPerice) {
		this.unitPerice = unitPerice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPetId() {
		return petId;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Pet) {
			Pet pet=(Pet)obj;
			return this.petId==pet.petId;
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.petId;
	}
	
	
	
}
