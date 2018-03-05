package tazklevellerapp;

import java.awt.Color;
import java.io.Serializable;

public class Preferences implements Serializable {
	
    private static final long serialVersionUID = 1L;

	private String userName;
	private Color color;
	
	
	public Preferences() {
		color = new Color(221,221,221);
	}
	
	public void setName(String name) {
		userName = name;
	}
	
	public void setColor(String stringColor) {
		String strColor=stringColor.toLowerCase();
		if (strColor.equals("light")) color = new Color(221, 221, 221);
		if (strColor.equals("dark")) color = new Color(68, 68, 68);
	}
	
	public Color getColor() {
		return color;
	}
	
	public String getName() {
		return userName;
	}
	
}
