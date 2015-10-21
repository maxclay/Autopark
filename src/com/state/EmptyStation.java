package com.state;

import com.main.resource.Resource;

public class EmptyStation extends State{
	
	public EmptyStation() {
		name = "empty gas station";
		fuel = 0;
		image = Resource.getImage("empty_gas");
	}

	@Override
	public short fillCar(int liter) {
		return 0;
	}

}
