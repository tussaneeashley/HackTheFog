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
		incompleteTasks.add(new Task(taskName,severity));
		totalTaskCount++;
		incompleteCount++;
	}
	
	public void removeTask(Task removedTask) {
		incompleteTasks.remove(removedTask);
		incompleteCount--;
		totalTaskCount--;
	}
	
	public void removeCompleted(Task completedTask) {
		completedTasks.remove(completedTask);
		completedCount--;
		totalTaskCount--;
	}
	
	public void setComplete(Task completedTask) {
		incompleteTasks.remove(completedTask);
		incompleteCount--;
		completedTasks.add(completedTask);
		completedCount++;
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
}
