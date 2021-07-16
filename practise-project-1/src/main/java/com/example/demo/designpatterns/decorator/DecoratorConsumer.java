package com.example.demo.designpatterns.decorator;

public class DecoratorConsumer {

	public static void main(String[] args) {
		Car car= new BasicCar();
		
		Car luxurySportsCar= new SportsCarDecorator(new LuxuryCarDecorator((Car)new BasicCar()));
		
		luxurySportsCar.assemble();
	}

}
