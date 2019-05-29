package com.example.demo;

import java.util.Arrays;
import java.util.Scanner;

public class LittleMonkandABD {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		
		long arr[]=new long[n];
		
		for(int i=0;i<n;i++)
			arr[i]=s.nextInt();
		
		sort(arr, n);
		
		int q=s.nextInt();
		
		while(q-->0) {
			int ind= s.nextInt();
			char ch= s.next().charAt(0);
			
			if(ch == 'L')
				System.out.println(arr[n-ind]);
			else
				System.out.println(arr[ind-1]);
			
				
		}
	}

	private static void sort(long[] arr, int n) {
		
		for(int i=n/2-1;i>=0;i--)
			heapify(arr, n, i);
		
		for(int i=n-1;i>=0;i--) {
			long temp=arr[0];
			arr[0]= arr[i];
			arr[i]=temp;
			
			heapify(arr,i,0);
		}
	}

	private static void heapify(long[] arr, long n, int i) {
		int largest= i;
		int left= i*2+1;
		int right= i*2+2;
		if(left<n && arr[largest]<arr[left])
			largest=left;
		
		if(right<n && arr[largest]<arr[right])
			largest= right;
		
		if(largest !=i) {
			long temp= arr[largest];
			arr[largest]=arr[i];
			arr[i]=temp;
			heapify(arr,n,largest);
		}
		
		
	}

}
