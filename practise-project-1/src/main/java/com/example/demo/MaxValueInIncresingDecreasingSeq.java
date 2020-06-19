package com.example.demo;


// Given an array in which elements are first increasing and then decreasing. find the maximum element in the array.
public class MaxValueInIncresingDecreasingSeq {

	public static void main(String[] args) {

		int arr[]= {7,6,5,4,2};
		
		
		System.out.println(findMax(arr,0,arr.length-1,(arr.length-1)/2));
		
	}

	private static int findMax(int[] arr,int l,int r,int mid) {
		if(l==r)
			return arr[l];
		
		
		if(arr[mid]<arr[mid+1])
			return findMax(arr, mid+1, r, (mid+1+r)/2);

		if(arr[mid]>arr[mid+1])
			return findMax(arr, l, mid, (l+mid-1)/2);
		
		return arr[mid];
	
	}

}
