package com.decorator;


import com.abstractfactory.Vehicle;
import com.main.resource.Resource;

public class ProSeller extends SellerDecorator {
	
	public ProSeller() {
		
		img = Resource.getImage("seller3");
		skill = 20;
		name = "pro seller";
		salary = 1000;
	}

	@Override
	public void setCarForSale(Vehicle car) {
		
		money += car.getCost() + (0.05 + 0.02 * Math.random()) * car.getCost();
	}
	


}
