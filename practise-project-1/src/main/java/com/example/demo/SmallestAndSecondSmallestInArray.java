package com.example.demo;

public class SmallestAndSecondSmallestInArray {

	public static void main(String[] args) {
		int arr[]= {2,4,3,5,6};
		
		func(arr);

	}

	private static void func(int[] arr) {
		
		int first=Integer.MAX_VALUE;
		int second=Integer.MAX_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<first) {
				second=first;
				first=arr[i];
			}
			else if(arr[i]<second && arr[i]!=first)
				second=arr[i];
		}
		if(second==Integer.MAX_VALUE) {
			System.out.println("-1");
			return;
		}
		System.out.println(first +" "+second);
	}
}
