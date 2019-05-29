package com.example.demo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MaxSumSubArray {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int n= s.nextInt();
		long arr[]=new long[n];
		
		for(int i=0;i<n;i++)
			arr[i]=s.nextInt();
		
		System.out.println(maxSubArraySum(arr,n));
	}

	private static long maxSubArraySum(long[] arr, int n) {
		
		Set<Long> set=new HashSet<>();
		int sum=0;
		
		for(int i=0;i<n;i++) {
			set.add(arr[i]);
			long maxSum= arr[i];
			long curMax= arr[i];
			
			for(int j=i+1;j<n;j++) {
				
				curMax=Math.max(arr[j], curMax+ arr[j]);
				maxSum= Math.max(maxSum, curMax);
				
				set.add(maxSum);
			}
		}

return set.stream().reduce((x,y)-> x+y).get();
	}

}
