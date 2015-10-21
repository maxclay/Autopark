package com.abstractfactory;

public class FordCompany extends AutoCompany {

	@Override
	public Jeep getJeep() {
		return new FordEscape();
	}

	@Override
	public Car getCar() {
		return new FordFocus();
	}

}
