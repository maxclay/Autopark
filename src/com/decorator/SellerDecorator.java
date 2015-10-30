package com.decorator;


public abstract class SellerDecorator implements Seller{
	
	protected Seller seller;
	
	public void toTeach(Seller seller)
	{
		this.seller = seller;
	}

}
