package com.decorator;


import java.awt.Graphics;
import java.awt.Image;

import com.abstractfactory.Vehicle;
import com.main.resource.Resource;

public class StandartSeller implements Seller{
	
	@SuppressWarnings("unused")
	private int skill;
	private Image img;
	
	protected float money;
	private String name;
	private float salary;
	
	public StandartSeller() {

		img = Resource.getImage("seller1");
		name = "standart seller";
		salary = 600.0f;
		skill = 5;
		money = 0;
	}

	@Override
	public void setCarForSale(Vehicle car) {
		
		money += car.getCost() + (0.03 + 0.02 * Math.random()) * car.getCost();
		
	}

	@Override
	public float getMoney() {
		return money;
	}

	@Override
	public void setMoney(float mn) {
		money = mn;
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

	@Override
	public void setImage(Image img) {
		this.img = img;		
	}

	@Override
	public Image getImage() {
		return img;
	}

	@Override
	public void setSkill(int skill) {
		this.skill = skill;		
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public float getSalary() {
		return salary;
	}
	
	

}
