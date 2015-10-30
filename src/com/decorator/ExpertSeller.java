package com.decorator;

import com.abstractfactory.Vehicle;
import com.main.resource.Resource;

public class ExpertSeller extends SellerDecorator {
	
	public void init() {
		
		seller.img = Resource.getImage("seller2");
		seller.skill = 10;
		seller.name = "expert seller";
		seller.salary = 700;
		
	}

	@Override
	public void setCarForSale(Vehicle car) {
		money += car.getCost() + (0.05 + 0.1 * Math.random()) * car.getCost();
		
	}
	

}
