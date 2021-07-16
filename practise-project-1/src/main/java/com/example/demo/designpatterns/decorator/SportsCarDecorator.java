package com.example.demo.designpatterns.decorator;

public class SportsCarDecorator extends CarDecorator{

	public SportsCarDecorator(Car car) {
		super(car);
	}
	
	public void assemble() {
		super.assemble();
		System.out.println("SportsCar feature added");
	}

}
