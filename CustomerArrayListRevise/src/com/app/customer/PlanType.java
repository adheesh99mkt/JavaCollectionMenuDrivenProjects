package com.app.customer;

public enum PlanType {
	SILVER(1000),
	GOLD(2000),
	DIAMOND(3000),
	PLATINUM(4000);
	private int charges;
	
	PlanType(int charges) {
		this.charges=charges;
	}
	public int getCharges() {
		return charges;
	}

	
	
}
