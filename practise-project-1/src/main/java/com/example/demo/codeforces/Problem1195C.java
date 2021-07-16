package com.example.demo.codeforces;

import java.util.Scanner;

public class Problem1195C {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		int n= s.nextInt();
		
		int h1[]= new int[n];
		int h2[]= new int[n];
		
		for(int i=0;i<n;i++)
			h1[i]= s.nextInt();
		for(int i=0;i<n;i++)
			h2[i]= s.nextInt();
		
		System.out.println(calc(h1, h2, n));
		
	}

	private static long calc(int[] h1, int[] h2, int n) {
		long dp1[]= new long[n];
		long dp2[]= new long[n];
		
		dp1[0]= h1[0]; dp2[0]= h2[0];
		if(n==1)
			return Math.max(h1[0], h2[0]);
		dp1[1]= dp2[0] + h1[1];
		dp2[1]= dp1[0] + h2[1];
		
		for(int i=2;i<n;i++) {
			long a = dp2[i-2] + h1[i];
			long b = dp2[i-1] + h1[i];
			
			dp1[i]= Math.max(a, b);
			
			long c = dp1[i-2] + h2[i];
			long d = dp1[i-1] + h2[i];
			
			dp2[i]= Math.max(c, d);
		}
		
		return Math.max(dp1[n-1], dp2[n-1]);
		
	}

}
