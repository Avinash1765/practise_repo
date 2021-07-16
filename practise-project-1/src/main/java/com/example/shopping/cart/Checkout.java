package com.example.shopping.cart;

import java.util.List;
import java.util.Map;

public interface Checkout {
	
	public double calculate(List<String> items,  Map<String, Double> priceMap);

}
