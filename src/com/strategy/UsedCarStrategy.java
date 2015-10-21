package com.strategy;

import java.util.ArrayList;
import java.util.Hashtable;

import com.abstractfactory.Vehicle;
import com.prototype.SparesPrototype;

public abstract class UsedCarStrategy extends Vehicle{
	
	
	protected boolean is_repaired;
	protected int reparing_time;
	protected Hashtable<String, Integer> catalogue;
	
	public abstract void repair(ArrayList<SparesPrototype> spares);
	
	
	public boolean isRepaired() {
		return is_repaired;
	}
	
	public Hashtable<String, Integer> getSpareCatalogue() {
		return catalogue;
	}
	
	public long getRepairingTime() {
		return reparing_time;
	}
	
	public abstract void setNewIcon();


	public abstract int getPercentScale();
	
}
