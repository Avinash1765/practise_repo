package com.example.demo;

import java.util.Scanner;

public class SpecialShop {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		
		while(t-->0) {
			int n=s.nextInt();
			int x=n/2;
			int y=n-x;
			
			int bigger= (y>x) ? y : x;
			int smaller= (y<=x) ? y : x;
			
			int a=s.nextInt();
			int b=s.nextInt();
			
			int inBig= (a>=b) ? a : b;
			int inLess= (a<b) ? a : b;
			
			long ans= (long)(smaller*smaller*inBig) + (long)(bigger*bigger*inLess);
			
			System.out.println(ans);
			
		}
	}

}
