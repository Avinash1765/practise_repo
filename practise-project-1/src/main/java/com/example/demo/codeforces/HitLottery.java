package com.example.demo.codeforces;

import java.util.Scanner;

public class HitLottery {
	
	//static int[] dp= new int[1000000000];

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);	
		int n= s.nextInt();
		
		System.out.println(fn(n));
	}

	private static int fn(int n) {
		if(n<5)
			return n;
		if(n>= 5 && n< 10)
			return (n/5) + fn(n%5);
		if(n>= 10 && n< 20)
			return (n/10) + fn(n%10);
		if(n>= 20 && n< 100)
			return (n/20) + fn(n%20);
		else
			return (n/100) + fn(n%100);
	}

}
