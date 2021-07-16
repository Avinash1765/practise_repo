package com.example.demo.codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class Problem189A {
	
	 static int dp[]= new int[4001];

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		int n= s.nextInt();
		int a= s.nextInt();
		int b= s.nextInt();
		int c= s.nextInt();
		
	    Arrays.fill(dp, Integer.MIN_VALUE);
		
		calcMaxPieces(n, a, b, c);
		
		System.out.println(dp[n]);
		
	}

	private static int calcMaxPieces(int n, int a, int b, int c) {
		if(n<0)
			return Integer.MIN_VALUE;
		if(n==0)
			return 0;
		
		if(dp[n]!= Integer.MIN_VALUE)
			return dp[n];

		int x=1+  calcMaxPieces(n-a, a, b, c);
		int y=1+  calcMaxPieces(n-b, a, b, c);
		int z=1+  calcMaxPieces(n-c, a, b, c);
		
		return (dp[n]= Math.max(Math.max(x, y), z));
	}

}
