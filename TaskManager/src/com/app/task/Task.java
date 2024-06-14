package com.app.task;

import java.time.LocalDate;

public class Task {
	//taskId, taskName, description, taskDate, status, active. 
	private int taskId;
	private String taskName;
	private String desc;
	private LocalDate taskDate;
	private Status status;
	private boolean active;
	
	private static int counter=0;
	public Task( String taskName, String desc, LocalDate taskDate) {
		super();
		counter++;
		this.taskId = counter;
		this.taskName = taskName;
		this.desc = desc;
		this.taskDate = taskDate;
		this.status=Status.PENDING;
		this.active=true;
	}
	public Task(int taskId) {
		this.taskId=taskId;
	}@Override
	public boolean equals(Object obj) {
		if(obj instanceof Task) {
			Task task=(Task)obj;
			return this.taskId==task.taskId;
		}
		return false;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public LocalDate getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getTaskId() {
		return taskId;
	}
	
	
	
}
