package com.state;

import java.awt.Graphics;


public class ContextStation {
	
	public enum GasStationStateSetting {
		Ready,
		Empty,
		Broken;
	}
	
	private float cost;
	
	private ReadyStation ready = new ReadyStation();
	private BrokenStation broken = new BrokenStation();
	private EmptyStation empty = new EmptyStation();
	
	private State currentState;
	
	public ContextStation() {
		
		this.cost = 10000;
		currentState = ready;

	}

	public void setState(GasStationStateSetting state) {
		
		switch (state) {
		
        	case Ready: this.currentState = ready; break;
        	case Empty: this.currentState = broken; break;
        	case Broken: this.currentState = empty; break;

        	default: System.out.println("State not found!"); break;
        	
		}
	}
	
	public int fillCar(int liter) {
		
		if(Math.random() > 0.97) {
			currentState = broken;
			return 0;
		}
		else {
			
			short tmp = currentState.fillCar(liter);
			if(tmp == 1) {
				return liter;
			}
			
			if(tmp == 0) {
				currentState = empty;
			}
			
		}
		
		return 0;
	}
	
	public void render(Graphics g) {
		currentState.render(g);
	}
	
	public float getCost() {
		return cost;
	}
	
	public String getName() {
		return currentState.getName();
	}

}
