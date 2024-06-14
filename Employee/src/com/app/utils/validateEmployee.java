package com.app.utils;

import java.time.LocalDate;
import java.util.Map;

import com.app.custome_exception.EmployeeCustomeExc;
import com.app.employee.EmpType;
import com.app.employee.Employee;

public class validateEmployee {
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}
	public static Employee validateAllInp(String name, String dateOfJoin, String phone, String aadhar,EmpType type,
			double salary,Map<String, Employee>empMap) throws EmployeeCustomeExc {
		validateAadhar(aadhar,empMap);
		validateAadharTemp(aadhar);
		validatePhone(phone);
		
		return new Employee(name, parseDate(dateOfJoin), phone, aadhar, type, salary);
	}
	public static void validateAadhar(String aadhar,Map<String, Employee>empMap) throws EmployeeCustomeExc {
		Employee emp=empMap.get(aadhar);
		if(emp!=null) {
			throw new EmployeeCustomeExc("Employe already present");
		}
	}
	public static void validatePhone(String phone) throws EmployeeCustomeExc {
		if(!(phone.length()!=10 || phone.matches(Employee.Template))) {
			throw new EmployeeCustomeExc("phone number is not valid!");
		}
	}
	public static void validateAadharTemp(String aadhar) throws EmployeeCustomeExc {
		if(!(aadhar.length()!=12 || (aadhar.matches(Employee.Template)&&aadhar.matches(Employee.TemplateAdhar)))) {
			throw new EmployeeCustomeExc("aadhar number is not valid!");
		}
	}
	
}
