package com.decorator;


import java.awt.Graphics;
import java.awt.Image;

import com.abstractfactory.Vehicle;
import com.main.resource.Resource;

public class ProSeller extends SellerDecorator {
	
	public void init() {
		
		seller.setImage(Resource.getImage("seller3"));
		seller.setSkill(20);
		seller.setName("pro seller");
		seller.setSalary(1000);
	}

	@Override
	public void setCarForSale(Vehicle car) {
		
		seller.setMoney(seller.getMoney() + car.getCost() + (float)(0.05 + 0.02 * Math.random()) * car.getCost());
	}
	
	@Override
	public float getMoney() {
		return seller.getMoney();
	}

	@Override
	public void setMoney(float mn) {
		seller.setMoney(mn);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(seller.getImage(), 620, 75, null);
		
	}

	@Override
	public void update() {
	}

	@Override
	public String getName() {
		return seller.getName();
	}

	@Override
	public float getSalary() {
		return seller.getSalary();
	}

	@Override
	public void setImage(Image img) {
		seller.setImage(img);
	}

	@Override
	public Image getImage() {
		return seller.getImage();
	}

	@Override
	public void setSkill(int skill) {
		seller.setSkill(skill);
	}

	@Override
	public void setName(String name) {
		seller.setName(name);
	}

	@Override
	public void setSalary(float salary) {
		seller.setSalary(salary);
	}

}
