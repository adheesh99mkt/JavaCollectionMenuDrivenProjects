package com.app.customer;

import java.time.LocalDate;

public class Customer {
	private int custid;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private double regAmount;
	private LocalDate dob;
	private PlanType plan;
	
	public static String passwordTemplate="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$#@*^%!]).{5,20})";
	public static String emailTemplate="\\w+@[a-zA-Z]+\\.(org|com|net)$";
			//"((?=.*\\d)(?=.*[a-z])(?=.*@)(?=.*.[com|org|net]))"; some error
	public static int counter=0;
	
	public Customer(String fname,String lname,String email,String password,double regAmount,LocalDate dob,PlanType plan) {
		counter++;
		this.custid=counter;
		this.fname=fname;
		this.lname=lname;
		this.email=email;
		this.password=password;
		this.regAmount=regAmount;
		this.dob=dob;
		this.plan=plan;
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "CustID:"+this.custid+"|FirstName:"+this.fname+"|LastName:"+this.lname+"|Email:"+this.email+
				"|RegAmount"+this.regAmount+
				"|DOB:"+this.dob+
				"|Plan:"+this.plan;
	}
	
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public PlanType getPlan() {
		return plan;
	}
	public void setPlan(PlanType plan) {
		this.plan = plan;
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		Customer.counter = counter;
	}

	
}
