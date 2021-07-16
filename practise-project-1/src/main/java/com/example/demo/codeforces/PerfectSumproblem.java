package com.example.demo.codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PerfectSumproblem {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = s.nextInt();
		
		int sum = s.nextInt();

		System.out.println(numSubSets(n, arr, sum));
		s.close();
	}

	private static long numSubSets(int n, int[] arr, int sum) {
		
		long[][] dp = new long[n][sum + 1];
		
		long mod= 1000000007;
		
		
		for(int i=0; i< n; i++)
			dp[i][0]= 1;
		
		for(int i=1; i<=sum; i++) {
			if(i== arr[0]) {
				dp[0][i]=1;
				break;
			}
		}
		
		for(int i=1;i<n;i++) {
			for(int j=1; j<= sum; j++) {
				dp[i][j] = (dp[i-1][j] + ((j- arr[i]) < 0 ? 0 : dp[i-1][j-arr[i]]))%mod;
			}
		}
		
		
		List<Integer> path= new ArrayList<>();
		
		printSubSetsRecur(dp, n-1, sum, path);
		
		return dp[n-1][sum];
	}

	private static void printSubSetsRecur(long[][] dp, int i, int j, List<Integer> path) {
		
	}

}
