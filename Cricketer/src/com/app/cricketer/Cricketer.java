package com.app.cricketer;

public class Cricketer {
	private String email;
	private String name;
	private String phone;
	private int age;
	private int rating;
	public Cricketer(String email, String name, String phone, int age, int rating) {
		super();
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.rating = rating;
	}
	public Cricketer(String email) {
		super();
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Cricketer [email=" + email + ", name=" + name + ", phone=" + phone + ", age=" + age + ", rating="
				+ rating + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Cricketer) {
			Cricketer c=(Cricketer)obj;
			return this.email.equals(c.email);
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.rating*this.age/3;
	}
	
}
