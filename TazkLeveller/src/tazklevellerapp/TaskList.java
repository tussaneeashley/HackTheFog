package tazklevellerapp;

import java.util.ArrayList;

public class TaskList {
	private int totalTaskCount = 0;
	private int incompleteCount = 0;
	private int completedCount = 0;
	
	private ArrayList<Task> incompleteTasks;
	private ArrayList<Task> completeTasks;

	public TaskList() {
		incompleteTasks = new ArrayList<Task>();
		completeTasks = new ArrayList<Task>();
	}
	
	public void addTask(Task task) {
		incompleteTasks.add(task);
		totalTaskCount++;
		incompleteCount++;
	}
	
	public void removeTask(Task removedTask) {
		incompleteTasks.remove(removedTask);
		incompleteCount--;
		totalTaskCount--;
	}
	
	public void removeCompleted(Task completedTask) {
		completeTasks.remove(completedTask);
		completedCount--;
		totalTaskCount--;
	}
	
	public void setComplete(Task completedTask) {
		incompleteTasks.remove(completedTask);
		incompleteCount--;
		completeTasks.add(completedTask);
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

	
}
