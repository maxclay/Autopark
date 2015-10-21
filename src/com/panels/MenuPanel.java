package com.panels;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import com.main.resource.Resource;

public class MenuPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private Image img;
	
	public MenuPanel() {
		Resource.loadImages();
		img = Resource.getImage("menu");
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img, 20, 0, null);
		g.drawImage(img, 550, 250, null);
	}

}
