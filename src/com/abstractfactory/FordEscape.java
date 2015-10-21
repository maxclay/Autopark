package com.abstractfactory;

import java.awt.Graphics;


import com.main.resource.Resource;

public class FordEscape extends Jeep{
	
	public FordEscape() {
		
		setBoughtTime();
		this.name = "Ford Escape";
		this.cost = 150000;
		this.extra_lights = false;
		this.issue_date = "2013-05-12";
		this.passenger_num = 5;
		this.winch = false;

		icon = Resource.getImage("escape");
		capacity = 200;
		is_full = false;
	}
	
	@Override
	public void drawIcon(Graphics g, int info_x) {
		g.drawImage(icon, info_x - 30, 65, null);
		
	}
}
