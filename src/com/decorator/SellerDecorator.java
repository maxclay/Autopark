package com.decorator;

public abstract class SellerDecorator extends Seller{
	
	protected Seller seller;
	
	public void toTeach(Seller seller)
	{
		this.seller = seller;
	}

}
