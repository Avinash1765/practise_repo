package com.example.demo;

public class CeilingInSortedArray {

	public static void main(String[] args) {
		
		int arr[]= {1, 2, 8, 10, 10, 12, 19};
		
		int key=19;
		
		celingInArray(arr,key);
	}

	private static void celingInArray(int[] arr, int key) {

		// for input arr: [1, 2, 8, 10, 10, 12, 19] key=5 gives index as 1 bcoz its equal ele or smaller element
		int index=findIndex(arr,0,arr.length-1,key);
		
		if(index ==-1 && key<arr[0]) {
			System.out.println("floor is -1, ceiling is "+ arr[0]);
		}
		else if(index ==-1 && key>arr[arr.length-1]) {
			System.out.println("ceil is -1, floor is "+ arr[arr.length-1]);
		}
		else {
			System.out.println("floor is "+ arr[index] + " ceiling is "+ arr[index+1]);
		}

	}

	private static int findIndex(int[] arr, int low, int high, int key) {
		
		int mid= low + (high-low)/2;

		if(low>high || (mid==0 && arr[mid]!=key) || (mid==arr.length-1 && arr[mid]!=key))
			return -1;
		
		if(arr[mid]==key)
			return mid;
		
		if(arr[mid]<key && (mid+1)<=arr.length-1 && arr[mid+1]>key)
			return mid;
		
		if(arr[mid]<key)
			return findIndex(arr, mid+1, high, key);
		return findIndex(arr, low, mid-1, key);
		
	}

}
