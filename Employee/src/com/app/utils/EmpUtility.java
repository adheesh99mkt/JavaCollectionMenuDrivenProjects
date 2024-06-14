package com.app.utils;

import java.util.Map;

import com.app.custome_exception.EmployeeCustomeExc;
import com.app.employee.Employee;

public class EmpUtility {
	public static String removeEmployee(int empid,Map<String,Employee >empMap) throws EmployeeCustomeExc {
		for (Employee e : empMap.values()) {
			if(e.getEmpId()==empid) {
				empMap.remove(e.getAadhar());
				return "employee removed";
			}
		}
		throw new EmployeeCustomeExc("employee not present..");
	}
	public static Employee getEmpByAadhar(String aadhar,Map<String,Employee >empMap) throws EmployeeCustomeExc {
		Employee emp=empMap.get(aadhar);
		if(emp==null) {
			throw new EmployeeCustomeExc("Employee is not present");
		}
		return emp;
	}
}
