package com.app.store;

public class User {
	private int id;
	private String password;
	private UserType type;
	
	private static int counter=0;

	public User(String password, UserType type) {
		super();
		counter++;
		this.id=counter;
		this.password = password;
		this.type = type;
	}

	public User(int id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", type=" + type + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User) {
			User user=(User)obj;
			return this.id==user.id;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return this.id;
	}
	
}
