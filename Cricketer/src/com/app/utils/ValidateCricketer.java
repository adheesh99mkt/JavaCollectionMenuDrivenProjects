package com.app.utils;

import java.util.Map;

import com.app.cricketer.Cricketer;
import com.app.custexception.CricketerCustExc;

public class ValidateCricketer {
	public static Cricketer validateEmail(String email,Map<String, Cricketer> cricketerMap) throws CricketerCustExc {
		Cricketer c=cricketerMap.get(email);
		if(c==null) {
			throw new CricketerCustExc("Cricker not valid");
		}
		return c;
	}
	public static Cricketer validateAllInput(String email, String name, String phone, int age, int rating,Map<String, Cricketer> cricketerMap) throws CricketerCustExc {
		emailDup(email, cricketerMap);
		return new Cricketer(email, name, phone, age, rating);
	}
	public static void emailDup(String email,Map<String, Cricketer> cricketerMap) throws CricketerCustExc{
		Cricketer c=cricketerMap.get(email);
		if(c!=null) {
			throw new CricketerCustExc("Cricker already present!");
		}
		
	}
}
