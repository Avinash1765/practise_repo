package com.example.demo;

import java.util.Scanner;


/**
 * @author atadiboy
 * this code helps in partitioning the strings into k groups with total sum of the strings in each group is same 
 *	this is not the actual solution for ICPC team management in hackerearth
 */
public class ICPCTeamManagement {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		
		while(t-->0) {
			int n=s.nextInt();
			int k=s.nextInt();
			int arr[]=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=s.next().length();
			}
			
			if(printIfDivisible(arr,n,k))
				System.out.println("Possible");
			else
				System.out.println("Not possible");
		}
	}

	private static boolean printIfDivisible(int[] arr, int n, int k) {
		
		boolean visited[]=new boolean[n];
		int totalSum=0;
		for(int i=0;i<n;i++)
			totalSum+=arr[i];
		
		if(k==0 || totalSum%k!=0)
			return false;
		if(k>n)
			return false;
		
		int eachBucketSum[]=new int[k];
		
		return printIfDivisibleRecur(arr,visited,0,k,eachBucketSum,0, totalSum/k);
	}

	private static boolean printIfDivisibleRecur(int[] arr, boolean[] visited, int currentBucketIndex, int k,int eachBucketSum[],int currentIndex, int maxBucketSum) {
		if(k==1)
			return true;
		
		if(maxBucketSum< eachBucketSum[currentBucketIndex])
			return false;
		
		if(maxBucketSum== eachBucketSum[currentBucketIndex])
			return printIfDivisibleRecur(arr, visited, currentBucketIndex+1, k-1, eachBucketSum, 0, maxBucketSum);
		
		for(int i=currentIndex;i<arr.length;i++) {
			if(!visited[i]) {
				visited[i]=true;
				eachBucketSum[currentBucketIndex]+= arr[i];
				if(printIfDivisibleRecur(arr, visited, currentBucketIndex, k, eachBucketSum, currentIndex+1, maxBucketSum))
					return true;
				
				visited[i]=false;
				eachBucketSum[currentBucketIndex]-= arr[i];
				
			}
		}
		
		
		return false;
	}

}
