package com.decorator;

import com.abstractfactory.Vehicle;
import com.main.resource.Resource;

public class ExpertSeller extends SellerDecorator {
	
	public ExpertSeller() {
		
		img = Resource.getImage("seller2");
		skill = 10;
		name = "expert seller";
		salary = 700;
		
	}

	@Override
	public void setCarForSale(Vehicle car) {
		money += car.getCost() + (0.05 + 0.1 * Math.random()) * car.getCost();
		
	}
	

}
