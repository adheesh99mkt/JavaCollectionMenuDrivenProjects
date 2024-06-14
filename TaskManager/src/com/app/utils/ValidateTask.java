package com.app.utils;

import java.time.LocalDate;
import java.util.List;

import com.app.customeexc.TaskCustExc;
import com.app.task.Status;
import com.app.task.Task;

public class ValidateTask {
	public static Task validateTask(String taskName,String taskDesc,String taskDate) {
		return new Task(taskName, taskDesc, parseDate(taskDate));
	}
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}
	public static Status parseStatus(String status) throws TaskCustExc {
		Status st=Status.valueOf(status.toUpperCase());
		if(st==null) {
			throw new TaskCustExc("status is not valid!");
		}
		return st;
	}
	public static Task valiadateId(int id,List<Task> taskList) throws TaskCustExc {
		Task task=new Task(id);
		int index=taskList.indexOf(task);
		if(index!=-1)
			return taskList.get(index);
		throw new TaskCustExc("Id is not valid");
	}
}
