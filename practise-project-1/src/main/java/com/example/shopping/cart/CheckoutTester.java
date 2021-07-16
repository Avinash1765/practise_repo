package com.example.shopping.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutTester {
	
	private Map<String, Double> priceMap= new HashMap<>();
	
	{
		priceMap.put("Apple", 1d);
		
		priceMap.put("Orange", 1d);
		
	}
	public static void main(String[] args) {
		CheckoutTester checkoutTester= new CheckoutTester();
		List<String> items= new ArrayList<>();
		items.add("Apple");
		items.add("Apple");
		items.add("Apple");
		items.add("Apple");
		items.add("Orange");
		items.add("Orange");
		items.add("Orange");
		items.add("Orange");
		items.add("Orange");
		items.add("Orange");
		
		Checkout checkout = new AppleDiscount(new OrangeDiscount(new SimpleCheckout()));
		
		System.out.println(checkout.calculate(items, checkoutTester.priceMap));
		
	}

}
