package com.example.demo;

public class Doubt {
	
	int data;

	public Doubt(int data) {
		super();
		this.data = data;
	}

	public void fun(Doubt obj) {
		Doubt obj2=obj;
		obj2.data=30;
	}

	public static void main(String[] args) {
		Doubt obj1=new Doubt(10);
		obj1.fun(obj1);
		System.out.println(obj1.data);
	}
}
