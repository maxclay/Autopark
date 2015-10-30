package com.decorator;

import java.awt.Graphics;
import java.awt.Image;
import com.abstractfactory.Vehicle;

public interface Seller {
	
	public void setImage(Image img);
	public Image getImage();
	public void setSkill(int skill);
	public float getMoney();
	public void setMoney(float mn);
	public void setName(String name);
	public String getName();
	public float getSalary();
	public void setSalary(float salary);
	public void update();
	public abstract void setCarForSale(Vehicle car);
	public void render(Graphics g);

}
