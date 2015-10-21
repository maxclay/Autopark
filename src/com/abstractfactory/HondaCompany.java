package com.abstractfactory;

public class HondaCompany extends AutoCompany{

	@Override
	public Jeep getJeep() {
		return new HondaHRV();
	}

	@Override
	public Car getCar() {
		return new HondaAccord();
	}

}
