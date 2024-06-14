package com.app.customeexc;

@SuppressWarnings("serial")
public class TaskCustExc extends Exception{
	public TaskCustExc(String msg) {
		super(msg);
	}
}
