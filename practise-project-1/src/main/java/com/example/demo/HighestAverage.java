package com.example.demo;

import java.util.Arrays;
import java.util.Scanner;

public class HighestAverage {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		//String str[]=s.nextLine().split(" ");
		
		long arr[]=new long[n];
		
		for(int i=0;i<n;i++)
			arr[i]=s.nextLong();
		
		int q=s.nextInt();
		
		Arrays.sort(arr);
		
		long prefix[]=new long[n];
		
		prefix[0]=arr[0];
		
		for(int i=1;i<n;i++)
			prefix[i]= arr[i] + prefix[i-1];
		
		while(q-->0) {
			long k=s.nextLong();
			
			int low=0, high=n-1;
			
			while(low<=high) {
				
				int mid= low + (high-low)/2;
				
				if(check(prefix, mid, k))
					low=mid+1;
				else
					high=mid-1;
			}
			System.out.println(low);
		}
			
	}

	private static boolean check(long[] prefix, int mid, long k) {
		if((prefix[mid]/(mid+1)) < k)
			return true;
		return false;
	}

}
