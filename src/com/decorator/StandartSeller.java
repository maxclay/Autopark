package com.decorator;


import com.abstractfactory.Vehicle;
import com.main.resource.Resource;

public class StandartSeller extends Seller{
	
	public StandartSeller() {
		
		super();
		img = Resource.getImage("seller1");
		name = "standart seller";
		salary = 600.0f;
		skill = 5;
	}

	@Override
	public void setCarForSale(Vehicle car) {
		
		money += car.getCost() + (0.03 + 0.02 * Math.random()) * car.getCost();
		
	}
	
	

}
