package com.example.shopping.cart;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OrangeDiscount extends DiscoutsCheckout{
	
	private static final String ORANGE = "Orange";

	public OrangeDiscount(Checkout checkout) {
		super(checkout);
	}
	
	public double calculate(List<String> items, Map<String, Double> priceMap) {
		double currentPrice= super.calculate(items, priceMap);
		
		int numOranges=Collections.frequency(items, ORANGE);
		
		return (currentPrice - ((numOranges * priceMap.get(ORANGE))/3));
	}
}
