package com.app.contact;

import java.time.LocalDate;

public class ContactID implements Comparable<ContactID>{
	private String name;
	private LocalDate dob;
	
	public ContactID(String name,LocalDate dob) {
		this.name=name;
		this.dob=dob;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name:"+this.name+" | DOB:"+this.dob;
	}
	public String getName() {
		return name;
	}
	public LocalDate getDob() {
		return dob;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof ContactID) {
			ContactID c=(ContactID)obj;
				return this.name.equals(c.name)&&this.dob.equals(c.dob);
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.name.hashCode()+this.dob.hashCode();

	}
	@Override
	public int compareTo(ContactID o) {
		int val=this.getName().compareTo(o.getName());
		if(val==0) {
			return this.getDob().compareTo(o.getDob());
		}
		return val;
	}
	
}
