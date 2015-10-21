package com.panels;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import com.main.resource.Resource;

public abstract class Panel extends JPanel{

	private static final long serialVersionUID = 1L;
	protected Image background;
	
	public Panel() {
		background = Resource.getImage("background");
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(background != null)
		g.drawImage(background, 0, 0, null);
	}
	
	public abstract void update();

}
