package com.app.validation;

import java.util.Map;

import com.app.custome_exception.CustomeExc;
import com.app.store.User;
import com.app.store.UserType;

public class ValidateUser {
	public static User login(int id,String password,Map<Integer, User>userMap) throws CustomeExc {
		User user=userMap.get(id);
		if(user==null) {
			throw new CustomeExc("Invalid user!!!!!!!!");
		}
		return user;
	}
	public static UserType parseUserType(String type) throws CustomeExc {
		UserType usertype=UserType.valueOf(type.toUpperCase());
		if(usertype==null) {
			throw new CustomeExc("Invalid user type");
		}
		return usertype;
	}
	public static User validateAllInp(String password,String userType) throws CustomeExc {
		return new User(password, parseUserType(userType));
	}
	public static User AdminLogin(int id,String password,Map<Integer, User>userMap) throws CustomeExc {
		User user=userMap.get(id);
		if(user!=null&&user.getType()==UserType.ADMIN) {
			return user;
			
		}
		throw new CustomeExc("You are not an ADMIN!!!!!!!!");
		
	}
	public static User CustomerLogin(int id,String password,Map<Integer, User>userMap) throws CustomeExc {
		User user=userMap.get(id);
		if(user!=null&&user.getType()==UserType.CUSTOMER) {
			return user;
			
		}
		throw new CustomeExc("Invalid user!!!!!!!!");
		
	}
	
}
