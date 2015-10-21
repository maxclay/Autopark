package com.decorator;

import java.awt.Graphics;

public abstract class Employee {
	
	protected String name;
	protected float salary;
	
	public abstract void render(Graphics g);
	public abstract void update();
	
	public abstract String getName();
	
	public float getSalary() {
		return salary;
	}
	
}
