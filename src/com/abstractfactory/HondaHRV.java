package com.abstractfactory;

import java.awt.Graphics;


import com.main.resource.Resource;

public class HondaHRV extends Jeep{
	
	public HondaHRV() {
		this.cost = 200000;
		this.extra_lights = false;
		this.issue_date = "2013-07-12";
		this.name = "Honda HR-V";
		this.passenger_num = 5;
		this.winch = false;
		setBoughtTime();

		icon = Resource.getImage("hrv");
		
		capacity = 220;
		is_full = false;
	}
	
	@Override
	public void drawIcon(Graphics g, int info_x) {
		g.drawImage(icon, info_x - 45, 40, null);
		
	}
	
}
