package com.app.tester;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.app.custsort.SortBasedOnDate;
import com.app.task.Status;
import com.app.task.Task;
import static com.app.utils.ValidateTask.*;
import static com.app.utils.TaskUtility.*;
public class Tester {

	public static void main(String[] args) {
		ArrayList<Task> taskList=new ArrayList<>();
		try(Scanner sc=new Scanner(System.in)){
			boolean exit=false;
			while(!exit) {
				try {
					System.out.println("1. Add New Task \n"
							+ "2. Delete a task  \n"  
							+ "3. Update task status \n" 
							+ "4. Display all pending tasks\n"
							+ "5. Display all pending tasks for today \n"
							+ "6. Display all tasks sorted by taskDate \n");
					switch (sc.nextInt()) {
					case 1:
						//add task
						//taskName, description, taskDate, status, active. 
						Task task=validateTask(sc.next(),sc.next(),sc.next());
						taskList.add(task);
						System.out.println("Task added");
						break;
					case 2:
						//delete task
						System.out.println("enter the task id");
						task=valiadateId(sc.nextInt(), taskList);
						System.out.println(deleteTask(task, taskList));
						for (Task t : taskList) {
							if(!(t.isActive())) {
								System.out.println(t);
							}
						}
						break;
					case 3:
						//update status
						System.out.println("enter the task id");
						task=valiadateId(sc.nextInt(), taskList);
						System.out.println("enter the status");
						System.out.println(updateStatus(task, taskList, sc.next()));
						break;
					case 4:
						System.out.println("All pending task");
						for (Task t : taskList) {
							if(t.getStatus()==Status.PENDING) {
								System.out.println(t);
							}
						}
						break;
					case 5:
						System.out.println("All pending task for today");
						for (Task t : taskList) {
							if(t.getStatus()==Status.PENDING && t.getTaskDate().equals(LocalDate.now())) {
								System.out.println(t);
							}
						}
						break;
					case 6:
						Collections.sort(taskList,new SortBasedOnDate());
						taskList.forEach(l->System.out.println(l));
						break;

					case 7:
						exit=true;
						break;
					}
				}
				catch (Exception e) {
					System.out.println(e);
					sc.nextLine();
				}
			}
		}
	}

}
