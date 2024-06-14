package com.app.utils;

import java.util.List;

import com.app.customeexc.TaskCustExc;
import com.app.task.Task;
import static com.app.utils.ValidateTask.*;

public class TaskUtility {
	public static String deleteTask(Task task,List<Task> taskList) {
		int index=taskList.indexOf(task);
		Task t=taskList.get(index);
		t.setActive(false);
		return "Task deleted";
	}
	public static String updateStatus(Task task,List<Task> taskList,String status) throws TaskCustExc {
		int index=taskList.indexOf(task);
		Task t=taskList.get(index);
		t.setStatus(parseStatus(status));
		return "Status updated";
	}
}
