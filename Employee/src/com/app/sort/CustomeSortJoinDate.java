package com.app.sort;

import java.util.Comparator;

import com.app.employee.Employee;

public class CustomeSortJoinDate implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getDateOfJoin().compareTo(o2.getDateOfJoin());
	}

}
