package com.state;

import java.awt.Graphics;
import java.awt.Image;

public abstract class State {
	
	protected int fuel;
	protected Image image;
	protected String name;
	
	public abstract short fillCar(int liter);
	
	public void render(Graphics g) {
		g.drawImage(image, 495, 118, null);
	}
	
	public String getName() {
		return name;
	}
}
