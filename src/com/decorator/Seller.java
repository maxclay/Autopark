package com.decorator;

import java.awt.Graphics;
import java.awt.Image;

import com.abstractfactory.Vehicle;

public abstract class Seller extends Employee{
	
	protected int skill;
	protected Image img;
	
	protected float money;
	
	public Seller() {
		money = 0;
	}
	
	@Override
	public void render(Graphics g) {

		g.drawImage(img, 620, 75, null);
		
	}

	@Override
	public void update() {

	}

	@Override
	public String getName() {
		return name;
	}
	
	public float getMoney() {
		return money;
	}
	
	public void setMoney(float mn) {
		money = mn;
	}
	
	public abstract void setCarForSale(Vehicle car);
	

}
