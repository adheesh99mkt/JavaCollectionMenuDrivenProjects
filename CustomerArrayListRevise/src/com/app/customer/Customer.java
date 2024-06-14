package com.app.customer;

import java.time.LocalDate;

public class Customer implements Comparable<Customer>{
	private int custId;
	private String email;
	private String fname;
	private String lname;
	private String password;
	private double regAmount;
	private LocalDate dob;
	private PlanType plan;
	
	public static int counter=0;
	public static String emailTemp="\\w+@[a-zA-Z]+\\.(org|com|net)$";
	public static String passTemp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$#@*^%!]).{5,20})";
	public Customer( String email, String fname, String lname, String password, double regAmount,
			LocalDate dob, PlanType plan) {
		super();
		counter++;
		this.custId = counter;
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.password = password;
		this.regAmount = regAmount;
		this.dob = dob;
		this.plan = plan;
	}
	public Customer(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "custId=" + custId + ", email=" + email + ", fname=" + fname + ", lname=" + lname
				+ ", regAmount=" + regAmount + ", dob=" + dob + ", plan=" + plan;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Customer) {
			return this.email.equals(((Customer)obj).email);
		}
		return false;
	}
	@Override
	public int compareTo(Customer o) {
		return this.email.compareTo(o.email);
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getPassword() {
		return this.password;
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
	
	
	
	
	
	
}
