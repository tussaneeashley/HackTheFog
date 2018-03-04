package tazklevellerapp;

public class Task {
	
	private String name;
	private int severity;
	private double hoursToFinish;
	
	public Task(String name) {
		this.name = name;
	}
	
	public Task(String name,int severity) {
		this.name = name;
		this.severity = severity;
	}
	
	public Task(String name,int severity,double hoursToFinish) {
		this.name = name;
		this.severity = severity;
		this.hoursToFinish = hoursToFinish;
	}
	
	public void editName(String newName) {
		this.name = newName;
	}
	
	public void setSeverity(int severity) {
		this.severity = severity;
	}
	
	public void setHours(double hours) {
		hoursToFinish = hours;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSeverity() {
		return severity;
	}
	
	public double getHours() {
		return hoursToFinish;
	}
	
}
