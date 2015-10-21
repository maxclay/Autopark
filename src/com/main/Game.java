package com.main;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.abstractfactory.Vehicle;
import com.decorator.Seller;
import com.panels.GaragePanel;
import com.panels.MenuPanel;
import com.panels.RepairPanel;
import com.panels.SalePanel;
import com.state.ContextStation;
import com.strategy.Mechanic;

public class Game {
	
	private Seller seller;
	private Mechanic mechanic;
	private ContextStation station;
	
	private ArrayList<Vehicle> new_cars;
	private ArrayList<Vehicle> used_cars;
	private ArrayList<Vehicle> repaired_cars;
	
	private static boolean oil_delivery = false;
	private static boolean casing_delivery = false;
	private static boolean paint_delivery = false;
	private static boolean spare_part_delivery = false;
	
	private static boolean week = false;
	private static boolean month = false;
	
	private float money;
	private boolean congratulations;
	
	public Game() {
		
		oil_delivery = false;
		casing_delivery = false;
		paint_delivery = false;
		spare_part_delivery = false;
		
		money = 500000;

		
		congratulations = false;
	}
	
	public void update() {
		if(mechanic != null) {
			mechanic.update();
		}
		
		if(seller != null) {

			seller.update();
			
			if(seller.getMoney() > 0) {
				money += seller.getMoney();
				seller.setMoney(0f);
			}
		}
		
		if(week) {
			
			if(mechanic!= null) {
				if(money >= mechanic.getSalary()) {
					money -= mechanic.getSalary();

				}
			}
			
			if(seller!= null) {
				if(money >= seller.getSalary())
					money -= seller.getSalary();

			}
			
			week = false;
		}
		
		if(month) {
			
			
			if(oil_delivery) {
				if(money >= 7000)
					money -= 7000;
				else {
					oil_delivery = false;
					
				}
			}
			
			if(casing_delivery) {
				if(money >= 10000)
					money -= 10000;
				else {
					casing_delivery = false;
					
				}
			}
			
			if(paint_delivery) {
				if(money >= 12000)
					money -= 12000;
				else {
					paint_delivery = false;
					
				}
			}
			
			if(spare_part_delivery) {
				if(money >= 21000)
					money -= 21000;
				else {
					spare_part_delivery = false;
					
				}
			}
			
			
			month = false;
		}
		
	}
	
	public float getMoney() {
		return money;
	}
	
	public void setMoney(float mn) {
		money = mn;
		if(money >= 10000000) {
			money = 9999999;
			
			if(!congratulations) {
				
				JFrame frame = new JFrame("Congratulations");
				frame.setSize(300, 300);
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
				frame.setLayout(null);
				frame.setLocationRelativeTo(null);
				
				MenuPanel panel = new MenuPanel();
				panel.setBounds(0, 0, 300, 300);
				panel.setLayout(null);
		
				
				JLabel label = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;You won!!!<br>Congratulations!!!</html>");
				label.setFont(new Font("Dialog", Font.BOLD, 34));
				label.setForeground(Color.BLUE);
				label.setBounds(0, 0, 300, 200);
				
				panel.add(label);
				frame.add(panel);
				
				congratulations = true;
				
			}
		}
	}
	
	
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
	public Seller getSeller() {
		return seller;
	}
	
	public void setMechanic(Mechanic mechanic) {
		this.mechanic = mechanic;
	}
	
	public Mechanic getMechanic() {
		return mechanic;
	}
	
	public static void week() {
		week = true;
	}
	
	public static void month() {
		month = true;
	}
	
	public void establishCasingDelivery() {
		casing_delivery = true;
	}
	
	public void establishPaintDelivery() {
		paint_delivery = true;
	}
	
	public void establishSparePartDelivery() {
		spare_part_delivery = true;
	}
	
	public void establishOilDelivery() {
		oil_delivery = true;
	}
	
	public static boolean isEstablishCasingDelivery() {
		return casing_delivery;
	}
	
	public static boolean isEstablishPaintDelivery() {
		return paint_delivery;
	}
	
	public static boolean isEstablishSparePartDelivery() {
		return spare_part_delivery;
	}
	
	public static boolean isEstablishOilDelivery() {
		return oil_delivery;
	}
	
	public void addNewCar(Vehicle car) {
		if(new_cars == null)
			new_cars = new ArrayList<Vehicle>();
		
		new_cars.add(car);

	}
	
	public void addUsedCar(Vehicle car) {
		if(used_cars == null)
			used_cars = new ArrayList<Vehicle>();
		
		used_cars.add(car);

	}
	
	public void addRepairedCar(Vehicle car) {
		
		used_cars.remove(car);
		RepairPanel.updateUsedCarList();
		GaragePanel.updateUsedCarList();
		GaragePanel.updateRepairedCarList();
		SalePanel.updateRepairedCarList();
		if(repaired_cars == null)
			repaired_cars = new ArrayList<Vehicle>();
		
		repaired_cars.add(car);

	}
	
	public ArrayList<Vehicle> getUsedCars() {
		return used_cars;
	}
	
	public ArrayList<Vehicle> getNewCars() {
		return new_cars;
	}
	
	public ArrayList<Vehicle> getRepairedCars() {
		return repaired_cars;
	}
	
	public void setGasStation(ContextStation station) {
		this.station = station;
	}
	
	public ContextStation getGasStation() {
		return station;
	}
	
}
