package com.example.demo;

import java.util.Scanner;

public class XsquareAndCoinCollection {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		
		while(t-->0) {
			int n=s.nextInt();
			int k=s.nextInt();
			
			int arr[]=new int[n];
			
			for(int i=0;i<n;i++)
				arr[i]=s.nextInt();
			
			long maxSum=0, currSum=0;
			
			for(int i=0;i<n;i++) {
				if(arr[i]<=k) {
					currSum = currSum + arr[i];
					if(currSum > maxSum)
						maxSum=currSum;
				}else {
					currSum=0;
				}
			}
			System.out.println(maxSum);
			
		}
	}

}
