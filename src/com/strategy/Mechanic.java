package com.strategy;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import com.main.Game;
import com.main.resource.Resource;
import com.panels.GaragePanel;
import com.panels.RepairPanel;
import com.prototype.SpareCache;
import com.prototype.SparesPrototype;

public class Mechanic {
	
	private UsedCarStrategy broken_car;
	private ArrayList<SparesPrototype> spares;
	
	private Image[] sprites;
	private int current_sprite;
	
	private long last_time;
	private long repair_beginning;
	
	private boolean repair;
	private Game game;
	
	private String name;
	private float salary;
	
	public Mechanic() {
		
		salary = 300.0f;
		repair = false;
		
		sprites = new Image[3];

		sprites[0] = Resource.getImage("mechanic1");
		sprites[1] = Resource.getImage("mechanic2");
		sprites[2] = Resource.getImage("mechanic3");
		
		current_sprite = 0;
		last_time = System.currentTimeMillis();
	}
	
	public void render(Graphics g) {

		g.drawImage(sprites[current_sprite], 680, 175, null);
		
	}

	public void update() {
		
//		System.out.println("Mechanic update!");
		
		long time = System.currentTimeMillis();
		
		if(time - last_time > 250) {
			last_time = time;
			current_sprite++;
			if(current_sprite > 2)
				current_sprite = 0;
			
		}
		
		if(repair) {
			if(System.currentTimeMillis() - repair_beginning > broken_car.getRepairingTime()) {
				
				if(broken_car.isRepaired()) {
					
					System.out.println("Car repaired successful. Time : " + broken_car.getRepairingTime());
				
					repair = false;
					RepairPanel.clearScreen();
					GaragePanel.clearScreen();
					broken_car.setNewIcon();
					game.addRepairedCar(broken_car);
					broken_car = null;
				}
				else {
					System.out.println("Error. Time : " + broken_car.getRepairingTime());
					repair = false;
				}
				GaragePanel.updateUsedCarList();
			}
		}
		
	}
	
	public long getRepairingTime() {
		if(broken_car != null && broken_car.isRepaired())
			return broken_car.getRepairingTime();
		
		return -1L;
	}
	
	public long getStartRepairingTime() {
		return repair_beginning;
	}

	public String getName() {
		return name;
	}
	
	public void setBrokenCar(UsedCarStrategy broken_car) {
		repair_beginning = System.currentTimeMillis();
		repair = true;
		this.broken_car = broken_car;
	}
	
	public UsedCarStrategy repairBrokenCar() {
		
			spares = new ArrayList<SparesPrototype>();
		
		for(int i = 0; i < broken_car.getSpareCatalogue().get("oil"); i++)
			if(Game.isEstablishOilDelivery())
				spares.add(SpareCache.getSpare("oil"));
		
		for(int i = 0; i < broken_car.getSpareCatalogue().get("spare_part"); i++)
			if(Game.isEstablishSparePartDelivery())
				spares.add(SpareCache.getSpare("spare_part"));
		
		for(int i = 0; i < broken_car.getSpareCatalogue().get("casings"); i++)
			if(Game.isEstablishCasingDelivery())
				spares.add(SpareCache.getSpare("casings"));
		
		for(int i = 0; i < broken_car.getSpareCatalogue().get("paint"); i++)
			if(Game.isEstablishPaintDelivery())
				spares.add(SpareCache.getSpare("paint"));
		
		broken_car.repair(spares);
		return broken_car;
		
	}
	
	public boolean isRepair() {
		return this.repair;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}

	public int getPercentScale() {
		
		return broken_car.getPercentScale();
		
	}

	public float getSalary() {
		return salary;
	}

}
