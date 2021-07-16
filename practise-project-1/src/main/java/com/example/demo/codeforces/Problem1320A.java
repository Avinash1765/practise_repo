package com.example.demo.codeforces;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Problem1320A {

	public static void main(String[] args) {
		try(Scanner s= new Scanner(System.in)){
		
		int n= s.nextInt();
		int beauty[]= new int[n];
		
		for(int i=0;i<n;i++)
			beauty[i]= s.nextInt();
		
		System.out.println(calculateMaxBeauty(n, beauty));
		}catch(Exception e) {
			throw e;
		}
	}

	private static long calculateMaxBeauty(int n, int[] beauty) {
		long dp[] = new long[n];
		
		Arrays.fill(dp, -1);
		
		if(n==1)
			return beauty[0];
		
		dp[n-1]= beauty[n-1];
		
		long maxVal= dp[n-1];
		
		for(int i=n-2;i>=0;i--) {
			for(int j=i+1;j<n;j++) {
				if((j-i) == beauty[j]-beauty[i]) {
					dp[i]= dp[j] + beauty[i];
					break;
				}
			}
			if(dp[i]==-1)
				dp[i]= beauty[i];
			maxVal = Math.max(maxVal, dp[i]);
		}
		
		return maxVal;
		
		
		
	}

}
