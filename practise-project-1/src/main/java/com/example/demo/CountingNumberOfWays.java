package com.example.demo;

import java.util.Scanner;

public class CountingNumberOfWays {
	static long modo= 10000000007L;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		
		long dp[][]=new long[100001][101];
		
		for(int i=1;i<100001;i++)
			dp[i][1]=1;
		
		for(int i=1;i<=100;i++)
			dp[1][i]=1;
		
		
		for(int i=2;i<= 10000;i++) {
			for(int j=2;j<=100;j++) {
				
				if(j>i) {
					dp[i][j]= dp[i][j-1];
				}else {
					long sum=0;
					
					for(int k=1;k<j;k++) {
						
					}
				}
				
			}
		}
		
		
		
		while(t-->0) {
			int x=s.nextInt();
			int k=s.nextInt();
			
			System.out.println(dp[x][k]);
			
			
		}
	}

}
