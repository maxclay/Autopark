package com.abstractfactory;

import java.awt.Graphics;


import com.main.resource.Resource;

public class FordFocus extends Car{
	
	public FordFocus() {
		setBoughtTime();
		this.body_type = "sedan";
		this.cost = 130000;
		this.issue_date = "2012-03-10";
		this.name = "Ford Focus";
		this.passenger_num = 5;
		this.sport_car = false;

		icon = Resource.getImage("focus");
		
		capacity = 150;
		is_full = false;
	}
	
	@Override
	public void drawIcon(Graphics g, int info_x) {
		g.drawImage(icon, info_x - 10, 80, null);
		
	}

}
