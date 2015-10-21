package com.abstractfactory;

import java.awt.Graphics;


import com.main.resource.Resource;

public class HondaAccord extends Car{
	
	public HondaAccord() {
		this.body_type = "sedan";
		this.cost = 120000;
		this.issue_date = "2012-03-03";
		this.name = "Honda Accord";
		this.passenger_num = 5;
		this.sport_car = false;
		icon = Resource.getImage("accord");
		setBoughtTime();
		
		capacity = 170;
		is_full = false;
	}
	
	@Override
	public void drawIcon(Graphics g, int info_x) {
		g.drawImage(icon, info_x - 10, 70, null);
		
	}
}
