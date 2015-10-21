package com.abstractfactory;

import java.awt.Graphics;
import java.awt.Image;

public abstract class Vehicle {
	
	protected String name;
	protected String issue_date;
	protected int passenger_num;
	protected Image icon;
	protected int capacity;
	protected boolean is_full;
	
	protected long serial;
	
	protected float cost;
	
	public String getName() {
		return this.name;
	}
	
	public void setBoughtTime() {
		serial = System.currentTimeMillis();
	}
	
	public long getSerial() {
		return serial;
	}
	
	public String getIssueDate() {
		return issue_date;
	}
	
	public int getPassangerNum() {
		return passenger_num;
	}
	
	public float getCost() {
		return cost;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public boolean isFull() {
		return is_full;
	}
	
	public void fill(int liter) {
		if(liter >= capacity) {
			is_full = true;
			cost += capacity * 3;
		}
	}
	
	public abstract void drawIcon(Graphics g, int info_x);
}
