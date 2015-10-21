package com.abstractfactory;

import java.awt.Graphics;


import com.main.resource.Resource;

public class VolkswagenTiguan extends Jeep{
	
	public VolkswagenTiguan() {
		this.cost = 240000;
		this.extra_lights = false;
		this.issue_date = "2013-12-22";
		this.name = "Volkswagen Tiguan";
		this.passenger_num = 5;
		this.winch = false;
		setBoughtTime();
		
		icon = Resource.getImage("tiguan");
		capacity = 210;
		is_full = false;
	}
	
	@Override
	public void drawIcon(Graphics g, int info_x) {
		g.drawImage(icon, info_x - 10, 80, null);
		
	}

}
