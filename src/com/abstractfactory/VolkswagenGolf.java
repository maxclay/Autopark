package com.abstractfactory;

import java.awt.Graphics;


import com.main.resource.Resource;

public class VolkswagenGolf extends Car{
	
	public VolkswagenGolf() {
		this.body_type = "hatchback";
		this.cost = 170000;
		this.issue_date = "2001-03-03";
		this.name = "Volkswagen Golf";
		this.passenger_num = 5;
		this.sport_car = false;
		setBoughtTime();

		icon = Resource.getImage("golf");
		capacity = 120;
		is_full = false;
	}
	
	@Override
	public void drawIcon(Graphics g, int info_x) {
		g.drawImage(icon, info_x - 45, 80, null);
		
	}

}
