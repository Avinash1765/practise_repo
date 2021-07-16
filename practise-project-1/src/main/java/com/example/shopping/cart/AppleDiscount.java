package com.example.shopping.cart;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AppleDiscount extends DiscoutsCheckout{
	
	private static final String APPLE = "Apple";

	public AppleDiscount(Checkout checkout) {
		super(checkout);
	}
	
	public double calculate(List<String> items, Map<String, Double> priceMap) {
		double currentPrice= super.calculate(items, priceMap);
		
		int numApples=Collections.frequency(items, APPLE);
		
		return currentPrice - (numApples * priceMap.get(APPLE))/2;
	}

}
