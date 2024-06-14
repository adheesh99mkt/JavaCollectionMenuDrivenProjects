package com.app.customer;

public enum PlanType {
	SILVER(1000),
	GOLD(2000),
	DIAMOND(3000);
	
	private int charges;
		
	private PlanType(int charges) {
		this.charges=charges;
	}
	
	public int getCharges() {
		return charges;
	}
	
}
