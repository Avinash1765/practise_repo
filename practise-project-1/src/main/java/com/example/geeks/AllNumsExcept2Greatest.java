package com.example.geeks;

import java.util.Scanner;

public class AllNumsExcept2Greatest {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t= s.nextInt();
		
		while(t-->0) {
			int n=s.nextInt();
			int arr[]=new int[n];
			
			for(int i=0;i<n;i++)
				arr[i]=s.nextInt();
			
			heapSort(arr, n);
		}
	}

	private static void heapSort(int[] arr, int n) {
		
		for(int i=n/2-1;i>=0;i--) 
			heapify(arr, n, i);
		
		for(int i=n-1;i>0;i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heapify(arr, i, 0);
			
		}
		
		for(int i=0;i<n-2;i++)
			System.out.print(arr[i]+" ");
	}

	private static void heapify(int[] arr, int n, int i) {
		int l= 2*i +1;
		int r= 2*i +2;
		
		int largestInd = i;
		
		if(l<n && arr[l]>arr[i])
			largestInd= l;
		
		if(r<n && arr[r]>arr[largestInd])
			largestInd= r;
		
		if(largestInd!= i) {
			int temp = arr[largestInd];
			arr[largestInd]= arr[i];
			arr[i]= temp;
			
			heapify(arr, n, largestInd);
		}
	}

}
