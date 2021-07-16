package com.example.shopping.cart;

import java.util.List;
import java.util.Map;

public class SimpleCheckout implements Checkout{

	@Override
	public double calculate(List<String> items,  Map<String, Double> priceMap) {
		
		return items.stream().mapToDouble(priceMap::get).sum();
	}

}
