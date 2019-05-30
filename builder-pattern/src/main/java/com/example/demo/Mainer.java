package com.example.demo;

public class Mainer {

	public static void main(String[] args) {
		
		Phone phone=new Phone.Builder().os("Android").build();
		
		System.out.println(phone.getOs());
		
	}

}
