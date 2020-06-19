package com.example.demo;

import java.util.Arrays;
import java.util.Scanner;

public class MinJumpsToReachEnd {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		
		while(t-->0) {
			int n=s.nextInt();
			int arr[]=new int[n];
			
			for(int i=0;i<n;i++)
				arr[i]=s.nextInt();
			
			//System.out.println(findMinJumps(arr,n));
			System.out.println(findMinJumps(arr,0,n-1));
		}
	}

	private static int findMinJumps(int[] arr, int index, int n) {
		
		if(index>=n)
			return 0;
		
		if(arr[index] ==0)
			return Integer.MAX_VALUE;
		
		if(arr[index] >= n-index-1)
			return 1;
		
		int min= Integer.MAX_VALUE;
		
		for(int j=index+1; j<= index+ arr[index]; j++) {
			int val=findMinJumps(arr, j, n);
			
			if(val != Integer.MAX_VALUE && val+1 < min)
				min= val+1;
		}
		
		return min;
		
	}
	
	// recusrion
	
	

	// DP solution
	/*private static int findMinJumps(int[] arr, int n) {
		int jumps[]=new int[n];
		
		
		if(arr[1]==0)
			return -1;
		
		for(int i=n-2;i>=0;i--) {
			
			if(arr[i]==0)
				jumps[i]= Integer.MAX_VALUE;
			
			else if(arr[i] >= n-1-i)
				jumps[i]=1;
			
			else {
				int min= Integer.MAX_VALUE;
			for(int j=i+1 ; j<n && j<=	(i + arr[i]);j++ ) {
				min= Math.min(min, jumps[j]);
			}
			if(min != Integer.MAX_VALUE)
				jumps[i]=min+1;
			else
				jumps[i]=min;
			}
		}
		return jumps[0];
	}*/

	// from left to right
	/*private static int findMinJumps(int[] arr,int n) {
		
		int jumps[]=new int[n];
		
		Arrays.fill(jumps, Integer.MAX_VALUE);
		
		if(arr[0]==0)
			return -1;
		
		for(int i=1 ; i<n;i++) {
				jumps[i]= Integer.MAX_VALUE;
			for(int j=0;j< i;j++) {
				
				if(j + arr[j] >= i && jumps[j]!= Integer.MAX_VALUE) {
					jumps[i]= Math.min(jumps[i], jumps[j]+1);
				}
			}
		}
		return jumps[n-1];
	}*/

}
