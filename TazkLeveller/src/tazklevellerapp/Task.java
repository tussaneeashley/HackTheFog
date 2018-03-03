package tazklevellerapp;

public class Task {
	
	private String name;
	private int severity;
	private int hoursToFinish;
	
	public Task(String name) {
		this.name = name;
	}
	
	public void editName(String newName) {
		this.name = newName;
	}
	
	public void setSeverity(int severity) {
		this.severity = severity;
	}
	
	public void setHours(int hours) {
		hoursToFinish = hours;
	}
	
}
