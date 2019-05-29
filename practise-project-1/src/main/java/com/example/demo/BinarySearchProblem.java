package com.example.demo;

/**
 * @author atadiboy
 *
 */

// find no of instances of key in sorted array using Bsearch O(logn)
public class BinarySearchProblem {

	public static void main(String[] args) {

		int arr[]= {2,3,3,3,3};
		
		int left=findLeftOccurence(arr,0,arr.length-1,2);
		int right=findRightOccurence(arr,0,arr.length-1,2);
		
		System.out.println( arr[left]==2 && arr[right]==2 ? (right-left+1) : 0);
	}

	private static int findRightOccurence(int[] arr, int l, int r, int k) {
		
		int mid;
		
		while((r-l)>1) {
			
			mid= (l + (r-l))/2;
			
			if(arr[mid]<=k)
				l=mid;
			else
				r=mid;
		}
		
		return l;
	}

	private static int findLeftOccurence(int[] arr, int l, int r, int k) {
		int mid;
		
		while((r-l)>1) {
			
			mid= (l + (r-l))/2;
			
			if(arr[mid]>=k)
				r=mid;
			else
				l=mid;
		}
		return r;
	}

}
