package com.app.custsort;

import java.util.Comparator;

import com.app.task.Task;

public class SortBasedOnDate implements Comparator<Task>{

	@Override
	public int compare(Task o1, Task o2) {
		// TODO Auto-generated method stub
		return o1.getTaskDate().compareTo(o2.getTaskDate());
	}

}
