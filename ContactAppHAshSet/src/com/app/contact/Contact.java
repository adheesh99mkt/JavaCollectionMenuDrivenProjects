/*For Phone Book Application 
Define a class Contact with the following fields – 
a.	Phone Number (Required,Updatable)
b.	Name (Required, Non-Updatable)
c.	Date of Birth (Required, Non-Updatable)
d.	Email (Required, Updatable)

Use appropriate java collection to store contacts in memory - 
to ensure no duplicates + constant time performance O(1)
Constraints:  
Two persons cannot have same Name & Date of Birth
*/
package com.app.contact;

import java.time.LocalDate;

public class Contact{ //implements Comparable<Contact>{
	private String phoneNumber;
	private String name;
	private LocalDate dob;
	private String email;
	private CountryCode country;
	private int code;
	
	public static String emailFormat="\\w+@[a-zA-Z]+\\.(org|com|net)$";
	
	public Contact(String phoneNumber,String name,LocalDate dob,String email,CountryCode country,int code) {
		this.phoneNumber=phoneNumber;
		this.name=name;
		this.dob=dob;
		this.email=email;
		this.country=country;
		this.code=code;
	}
	public Contact(String name,LocalDate dob) {
		this.name=name;
		this.dob=dob;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "| Phone Number: "+"+"+this.code+" "+this.phoneNumber+"| NAME: "+this.name+
				"| BOB:"+this.dob+"| EMAIL:"+this.email+"| Country:"+this.country;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Contact) {
			Contact c=(Contact)obj;
			return this.name.equals(c.name) && this.dob.equals(c.dob);
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.name.hashCode()+this.dob.hashCode();
	}
	//@Override
//	public int compareTo(Contact c) {
//		// TODO Auto-generated method stub
//		int val=this.name.compareTo(c.name);
//		if(val==0) {
//			return this.dob.compareTo(c.dob);
//		}
//		return val;
//	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public CountryCode getCountry() {
		return country;
	}
	public void setCountry(CountryCode country) {
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public int getCode() {
		return code;
	}
	
	
	
}
