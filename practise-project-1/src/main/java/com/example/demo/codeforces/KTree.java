package com.example.demo.codeforces;

import java.util.Scanner;

public class KTree {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int n= s.nextInt();
		int k= s.nextInt();
		int d= s.nextInt();
		
		findWays(n, k, d);
	}

	private static void findWays(int n, int k, int d) {
		
		long val= 1000000007;
		long ans=0l;
		
		for(int i=d;i<=k;i++) {
			count(k, (n-i));
		}
	}

	private static void count(int k, int s) {
		
	}

}
