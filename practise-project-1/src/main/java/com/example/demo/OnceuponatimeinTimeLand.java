package com.example.demo;

import java.util.Arrays;
import java.util.Scanner;

public class OnceuponatimeinTimeLand {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		
		while(t-->0) {
			int n=s.nextInt();
			int k=s.nextInt();
			
			int arr[]=new int[n];
			
			for(int i=0;i<n;i++)
				arr[i]=s.nextInt();
			
			solve(arr, n,k);
			
		}
	}

	private static void solve(int[] arr, int n, int k) {
		long dp[]=new long[n];
		
		dp[0]= (arr[0] >0) ? arr[0] : 0;
		
		for(int i=1;i<n;i++) {
			long val1= dp[i-1];
			
			int ele= (arr[i] >0) ? arr[i] : 0;
			long ele2= (i-k-1)>=0 ? dp[i-k-1] : 0;
			
			dp[i]= Math.max(val1, ele2 + ele);
			
		}
		
		System.out.println(dp[n-1]);
	}

}
