package com.app.utils;

import java.util.Map;

import com.app.cricketer.Cricketer;
import com.app.custexception.CricketerCustExc;

public class Utility {
	
	public static Cricketer searchByName(String name,Map<String, Cricketer>cricketerMap) throws CricketerCustExc {
		for (Cricketer c : cricketerMap.values()) {
			if(c.getName().equals(name)) {
				return c;
			}
		}
		throw new CricketerCustExc("Cricketer is not valid!");
	}
}
