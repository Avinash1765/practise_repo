package com.example.shopping.cart;

import java.util.List;
import java.util.Map;

public abstract class DiscoutsCheckout implements Checkout{

	private Checkout checkOut;
	
	public DiscoutsCheckout(Checkout checkout) {
		this.checkOut = checkout;
	}
	
	@Override
	public double calculate(List<String> items, Map<String, Double> priceMap) {
		return this.checkOut.calculate(items, priceMap);
	}
}
