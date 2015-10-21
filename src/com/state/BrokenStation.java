package com.state;


import com.main.resource.Resource;

public class BrokenStation extends State{
	
	public BrokenStation() {
		name = "broken gas station";
		fuel = 0;
		image = Resource.getImage("broken_gas");
	}

	@Override
	public short fillCar(int liter) {
		return -1;
	}

}
