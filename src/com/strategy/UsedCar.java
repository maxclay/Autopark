package com.strategy;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Hashtable;

import com.main.resource.Resource;
import com.prototype.SparesPrototype;

public class UsedCar extends UsedCarStrategy {
	
	public final static int OIL_NUM_FOR_REPAIR = 2;
	public final static int CASINGS_NUM_FOR_REPAIR = 4;
	public final static int PAINT_NUM_FOR_REPAIR = 3;
	public final static int SPARE_PARTS_NUM_FOR_REPAIR = 23;
	
	private final static int MS_PERCENT = 200;
	
	private boolean is_engine_repaired;
	private boolean is_body_repaired;
	private boolean is_wheel_repaired;
	private boolean is_transmission_repaired;
	
	public UsedCar() {
		
		capacity = 180;
		is_full = false;
		
		catalogue = new Hashtable<String, Integer>();
		catalogue.put("oil", OIL_NUM_FOR_REPAIR);
		catalogue.put("casings", CASINGS_NUM_FOR_REPAIR);
		catalogue.put("spare_part", SPARE_PARTS_NUM_FOR_REPAIR);
		catalogue.put("paint", PAINT_NUM_FOR_REPAIR);
		
		reparing_time = 5 * MS_PERCENT;
		
		is_engine_repaired = false;
		is_body_repaired = false;
		is_wheel_repaired = false;
		is_transmission_repaired = false;
		
		is_repaired = false;
		
		setBoughtTime();
		this.cost = 14000;
		this.issue_date = "2000-05-05";
		this.name = "Opel Vectra";
		this.passenger_num = 5;
		
		icon = Resource.getImage("car_before_icon");
	}

	@Override
	public void repair(ArrayList<SparesPrototype> spares) {
		
		int oil_num = 0;
		int spares_parts_num = 0;
		int casings_num = 0;
		int paint_num = 0;
			
		for(SparesPrototype tmp : spares) {
			
			if(tmp.getName().equals("oil"))
				oil_num++;
			
			if(tmp.getName().equals("casings"))
				casings_num++;
			
			if(tmp.getName().equals("paint"))
				paint_num++;
			
			if(tmp.getName().equals("spare_part"))
				spares_parts_num++;
		}
		
		
		if(oil_num >= OIL_NUM_FOR_REPAIR && casings_num >= CASINGS_NUM_FOR_REPAIR && 
				paint_num >= PAINT_NUM_FOR_REPAIR && spares_parts_num >= SPARE_PARTS_NUM_FOR_REPAIR) {
			
			if(!is_engine_repaired && oil_num > 0 && spares_parts_num > 9) {
				reparing_time += 25 * MS_PERCENT;
				
				int spares_parts_num_used = 0;
					
				for(int i = 0; i < spares.size(); i++) {
					
					if(spares.get(i).getName().equals("oil")) {
						oil_num--;

						spares.remove(i);
						if(i != 0)
							i--;
					}
					
					if(spares.get(i).getName().equals("spare_part") && spares_parts_num_used < 10) {
						spares_parts_num_used++;
						spares_parts_num--;

						spares.remove(i);
						if(i != 0)
						i--;
					}
				}
				
				is_engine_repaired = true;
			}
			
			if(!is_body_repaired && paint_num > 1 && spares_parts_num > 4) {
				
				reparing_time += 40 * MS_PERCENT;
				
				int spares_parts_num_used = 0;
				int paint_num_used = 0;
					
				for(int i = 0; i < spares.size(); i++) {
					
					if(spares.get(i).getName().equals("paint") && paint_num_used < 2) {

						spares.remove(i);
						paint_num_used++;
						paint_num--;
						if(i != 0)
						i--;
					}
					
					if(spares.get(i).getName().equals("spare_part") && spares_parts_num_used < 5) {
						spares_parts_num_used++;
						spares_parts_num--;

						spares.remove(i);
						if(i != 0)
						i--;
					}
				}
				
				is_body_repaired = true;
				
			}
			
			if(!is_wheel_repaired && casings_num > 3 && paint_num > 0 && spares_parts_num > 2) {
				
				reparing_time += 10 * MS_PERCENT;
				
				int spares_parts_num_used = 0;
				int casings_num_used = 0;
					
				for(int i = 0; i < spares.size(); i++) {
					
					if(spares.get(i).getName().equals("paint")) {

						spares.remove(i);
						
						paint_num--;
						if(i != 0)
						i--;
					}
					
					if(spares.get(i).getName().equals("casings") && casings_num_used < 4) {
						casings_num_used++;
						casings_num--;

						spares.remove(i);
						if(i != 0)
						i--;
					}
					
					if(spares.get(i).getName().equals("spare_part") && spares_parts_num_used < 3) {
						spares_parts_num_used++;
						spares_parts_num--;

						spares.remove(i);
						if(i != 0)
						i--;
					}
				}
				
				is_wheel_repaired = true;
			}
			
			if(!is_transmission_repaired && oil_num > 0 && spares_parts_num > 4) {
				reparing_time += 20 * MS_PERCENT;
				
				int spares_parts_num_used = 0;
					
				for(int i = 0; i < spares.size(); i++) {
					
					if(spares.get(i).getName().equals("oil")) {
						oil_num--;

						spares.remove(i);
						if(i != 0)
						i--;
					}
					
					if(spares.get(i).getName().equals("spare_part") && spares_parts_num_used < 5) {
						spares_parts_num_used++;
						spares_parts_num--;

						spares.remove(i);
						if(i != 0)
						i--;
					}
				}
				
				is_transmission_repaired = true;
			}
			
			if(is_transmission_repaired && is_wheel_repaired && is_body_repaired && is_engine_repaired) {
	
				is_repaired = true;
			}

			
		}
		
	}

	@Override
	public void drawIcon(Graphics g, int info_x) {
		
		g.drawImage(icon, info_x - 50, 70, null);
		
	}

	@Override
	public void setNewIcon() {
		
		icon = Resource.getImage("car_after_icon");
		cost += cost * 0.4f;
	}

	@Override
	public int getPercentScale() {
		return MS_PERCENT;
	}

}
