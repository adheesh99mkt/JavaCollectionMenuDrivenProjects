package com.app.employee;

import java.time.LocalDate;

public class Employee {
	//Name, Date of joining, Phone Number, Aadhaar number  
	//For FTE, monthly salary is also captured.
	//For PTE, hourly payment amount is also captured.
	private int empId;
	private String name;
	private LocalDate dateOfJoin;
	private String phone;
	private String aadhar;
	private EmpType empType;
	private double salary;
	
	
	public static int counter=0;
	public static String Template="^[0-9]*$";
	public static String TemplateAdhar="^\\S+$";
	
	public Employee(String name, LocalDate dateOfJoin, String phone, String aadhar,EmpType empType,
			double salary) {
		
		counter++;
		this.empId=counter;
		this.name = name;
		this.dateOfJoin = dateOfJoin;
		this.phone = phone;
		this.aadhar = aadhar;
		this.empType = empType;
		this.salary = salary;
	}
	





	


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", dateOfJoin=" + dateOfJoin + ", phone=" + phone
				+ ", aadhar=" + aadhar + ", empType=" + empType + ", salary=" + salary + "]";
	}



	





	public int getEmpId() {
		return empId;
	}









	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getDateOfJoin() {
		return dateOfJoin;
	}


	public void setDateOfJoin(LocalDate dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public EmpType getEmpType() {
		return empType;
	}


	public void setEmpType(EmpType empType) {
		this.empType = empType;
	}


	

	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}



	



	public String getAadhar() {
		return aadhar;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.empId;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			Employee emp=(Employee)obj;
			return this.aadhar.equals(emp.aadhar);
		}
		return false;
	}
	
	

}
