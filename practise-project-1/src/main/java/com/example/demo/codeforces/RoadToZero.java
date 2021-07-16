package com.example.demo.codeforces;

import java.util.Scanner;

public class RoadToZero {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t= s.nextInt();
		while(t-->0) {
			long x = s.nextLong();
			long y = s.nextLong();
			long a = s.nextLong();
			long b = s.nextLong();
			findMinCost(x,y,a,b);
		}
	}



	private static void findMinCost(long x, long y, long a, long b) {
		long t1 = (x+y) * a;
		long t2 = (Math.abs(x-y) *a ) + Math.min(x, y) * b;
		
		System.out.println(Math.min(t2, t1));

	}

}


