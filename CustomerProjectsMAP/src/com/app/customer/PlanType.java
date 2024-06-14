package com.app.customer;

public enum PlanType {
	SILVER(1000), 
	GOLD(2000),
	DIAMOND(5000),
	PLATINUM(10000);
	
	private int charges;

	PlanType(int charges) {
		// TODO Auto-generated constructor stub
		this.charges=charges;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name()+":"+this.charges;
	}
	public int getCharges() {
		return this.charges;
	}
	

}
