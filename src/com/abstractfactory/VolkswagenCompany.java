package com.abstractfactory;

public class VolkswagenCompany extends AutoCompany {

	@Override
	public Jeep getJeep() {
		return new VolkswagenTiguan();
	}

	@Override
	public Car getCar() {
		return new VolkswagenGolf();
	}

}
