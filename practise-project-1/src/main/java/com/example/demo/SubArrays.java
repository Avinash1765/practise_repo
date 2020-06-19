package com.example.demo;

import java.util.Scanner;

public class SubArrays {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		
		long arr[]=new long[n];
		
		//String strArr[]=s.nextLine().split(" ");
		
		for(int i=0;i<n;i++)
			arr[i]=s.nextLong();
		
		
		long maxSum=0;
		long currSum=0;
		for(int i=0;i<n;i++) {
			 long ele=currSum + arr[i];
			if(ele <0) {
				currSum=0;
			}else {
				currSum = ele;
				//currSum = Math.max(currSum, ele);
				maxSum = Math.max(currSum, maxSum);
			}
		}
		int k=0;
		currSum=0;
		for(int i=0;i<n;i++) {
			currSum+= arr[i];
			
			if(currSum<0) {
				currSum=0;
			}
			
			if(currSum== maxSum) {
				k++;
				currSum=0;
			}
		}
		
		System.out.println(maxSum+" "+k);
		
	}

}
