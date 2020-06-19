package com.example.demo;

import java.util.Arrays;
import java.util.Scanner;

public class PartitionSetForEqualSums {
	static int leftSum=Integer.MIN_VALUE;
	static int rightSum=Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		
		while(t>0) {
			int n=s.nextInt();
			int arr[]=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=s.nextInt();
			}
			System.out.println(findResult(arr,n));
			t--;
		}
	}

	private static String findResult(int[] arr, int n) {
		Arrays.sort(arr);
		
		int ind=0;
		
		while(leftSum<=rightSum && ind>=0 && ind<=n-2) {
			
			updateSums(arr,ind,n);
			
			if(leftSum==rightSum)
				return "YES";
			else if(leftSum<rightSum)
				ind++;
			else
				ind--;
		}
		
		
		
		if(leftSum==rightSum)
			return "YES";
		else
			return "NO";
	}

	private static void updateSums(int[] arr, int ind,int n) {
		int leftArr[]=Arrays.copyOfRange(arr, 0, ind+1);
		int rightArr[]=Arrays.copyOfRange(arr, ind+1, n);
		
		leftSum=updateSumInVariable(leftArr);
		rightSum=updateSumInVariable(rightArr);
		
	}

	private static int updateSumInVariable(int[] arr) {
		int sum=0;
		for(int i=0;i<arr.length;i++)
			sum+=arr[i];
		return sum;
	}

}
