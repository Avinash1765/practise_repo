package com.example.demo.codeforces;

import java.util.Scanner;

public class SubsetSumProblem {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[]= new int[n];
		
		for(int i=0;i<n;i++)
			arr[i]= s.nextInt();
		
		System.out.println(equalPartition(n, arr));
		
	}

	static int equalPartition(int n, int arr[]) {
			long totalSum = 0l;
			
			for(int i=0; i<n; i++)
				totalSum+= arr[i];
			
			if(totalSum%2==1)
				return 0;
			
			boolean flag= check(arr, n, totalSum/2, 0, 0);
			
			return flag ? 1 : 0;
	}

	private static boolean check(int[] arr, int n, long k, int ind, long ans) {
			if(k==0)
				return true;
			
			for(int i= ind; i<n; i++) {
				ans += arr[i];
				
				boolean flag=check(arr, n, k - arr[i], i+1, ans);
				if(flag)
					return true;
				else
					ans -= arr[i];
			}
			
			return false;
	}

}
