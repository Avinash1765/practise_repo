package com.example.demo.codeforces;

import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int m= s.nextInt();
		
		int coins[]= new int[m];
		for(int i=0;i<m;i++)
			coins[i]= s.nextInt();
		
		System.out.println(count(coins, m, n));
	}

	private static long count(int[] s, int m, int n) {
		
		long ways[]= new long[n+1];
		ways[0]=1;
		
		
		for(int i=1;i<=n;i++) {
			long sum=0;
			
			for(int j=0; j<m;j++) {
				sum += ( i - s[j] < 0 ? 0 : ways[i - s[j]]);
			}
			
			ways[i]= sum;
		}
		
		return ways[n];
	}

}
