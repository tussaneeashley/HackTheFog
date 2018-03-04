package tazklevellerapp;

import java.io.Serializable;
import java.util.ArrayList;

public class TaskList implements Serializable{
	private int totalTaskCount = 0;
	private int incompleteCount = 0;
	private int completedCount = 0;
	
	private ArrayList<Task> incompleteTasks;
	private ArrayList<Task> completedTasks;

	public TaskList() {
		incompleteTasks = new ArrayList<Task>();
		completedTasks = new ArrayList<Task>();
	}
	
	public void addTask(Task task) {
		incompleteTasks.add(task);
		totalTaskCount++;
		incompleteCount++;
	}
	
	public void addTask(String taskName,int severity) {
		insertIncomplete(new Task(taskName,severity));
		totalTaskCount++;
		incompleteCount++;
	}
	
	public void removeTask(Task removedTask) {
		incompleteTasks.remove(removedTask);
		incompleteCount--;
		totalTaskCount--;
	}
	
	public void removeTask(int index) {
		Task task = incompleteTasks.get(index);
		removeTask(task);
	}
	
	public void removeCompleted(Task completedTask) {
		completedTasks.remove(completedTask);
		completedCount--;
		totalTaskCount--;
	}
	
	public void removeCompleted(int index) {
		Task task = completedTasks.get(index);
		removeCompleted(task);
	}
	
	public void setComplete(Task completedTask) {
		incompleteTasks.remove(completedTask);
		incompleteCount--;
		insertComplete(completedTask);
		completedCount++;
	}
	
	public void setComplete(int index) {
		Task task = incompleteTasks.get(index);
		setComplete(task);
	}
	
	public int getTotalCount() {
		return totalTaskCount;
	}
	
	public int getIncompleteCount() {
		return incompleteCount;
	}
	
	public int getCompletedCount() {
		return completedCount;
	}

	public String getNameIncomplete(int index) {
		return incompleteTasks.get(index).getName();
	}
	
	public String getNameComplete(int index) {
		return completedTasks.get(index).getName();
	}
	
	public String getSeverityIncomplete(int index) {
		return incompleteTasks.get(index).getSeverity();
	}
	
	public String getSeverityComplete(int index) {
		return completedTasks.get(index).getSeverity();
	}
	
	public void insertIncomplete(Task task){
	    // loop through all elements
	    for (int i = 0; i < incompleteCount; i++) {
	        // if the element you are looking at is smaller than x, 
	        // go to the next element
	        if (incompleteTasks.get(i).getSeverityInt() < task.getSeverityInt()) continue;
	        // otherwise, we have found the location to add x
	        incompleteTasks.add(i, task);
	        return;
	    }
	    // we looked through all of the elements, and they were all
	    // smaller than x, so we add ax to the end of the list
	    incompleteTasks.add(task);
	}
	
	public void insertComplete(Task task){
	    // loop through all elements
	    for (int i = 0; i < completedCount; i++) {
	        // if the element you are looking at is smaller than x, 
	        // go to the next element
	        if (completedTasks.get(i).getSeverityInt() < task.getSeverityInt()) continue;
	        // otherwise, we have found the location to add x
	        completedTasks.add(i, task);
	        return;
	    }
	    // we looked through all of the elements, and they were all
	    // smaller than x, so we add ax to the end of the list
	    completedTasks.add(task);
	}
}
