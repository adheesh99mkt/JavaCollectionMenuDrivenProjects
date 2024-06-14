package com.app.contact;



public class Contact {
	private String phoneNum;
	private ContactID contactid;	
	private String email;
	private CountryCode country;
	private int countrycode;
	
	public static String emailFormat="\\w+@[a-zA-Z]+\\.(org|com|net)$";
	
	public Contact(ContactID contactid,CountryCode country,String phone,String email,int countrycode) {
		this.phoneNum=phone;
		this.contactid=contactid;
		this.email=email;
		this.country=country;
		this.countrycode=countrycode;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return contactid.toString()+" | Phone Number:"+"+"+this.countrycode+" "+this.phoneNum+
				" | Email:"+this.email+" | Country:"+this.country;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
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
	public int getCountrycode() {
		return countrycode;
	}

	public ContactID getContactid() {
		return contactid;
	}
	
}
