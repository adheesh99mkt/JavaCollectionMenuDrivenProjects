package com.app.contact;

public enum CountryCode {
	INDIA(91),BRAZIL(55),
	DENMARK(45),EGYPT(20),
	FRANCE(33);
	private int code;
	
	CountryCode(int code) {
		this.code=code;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name()+":+"+this.code;
	}
	public int getCode() {
		return this.code;
	}
}
