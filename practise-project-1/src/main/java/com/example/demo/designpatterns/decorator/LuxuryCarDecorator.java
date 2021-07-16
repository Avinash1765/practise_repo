package com.example.demo.designpatterns.decorator;

public class LuxuryCarDecorator extends CarDecorator{

	public LuxuryCarDecorator(Car car) {
		super(car);
	}
	
	public void assemble() {
		super.assemble();
		System.out.println("Luxury car feature added");
	}

}
