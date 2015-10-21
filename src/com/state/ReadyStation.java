package com.state;


import com.main.resource.Resource;

public class ReadyStation extends State{
	
	public ReadyStation() {
		name = "ready gas station";
		fuel = 2000;
		image = Resource.getImage("ready_gas");
	}

	@Override
	public short fillCar(int liter) {
		
		fuel -= liter;
		if(fuel <= 0) {
			fuel = 2000;
			return 0;
		}
		
		return 1;
	}


}
