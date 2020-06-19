package com.example.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

import ch.qos.logback.core.spi.ScanException;

public class EvenOddSubArrays {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++) {
			int ele=s.nextInt();
			
			if(ele%2==0)
				arr[i]=1;
			else
				arr[i]=-1;
		}
		
		countEvenOddSubs(arr,n);
	}

	private static void countEvenOddSubs(int[] arr, int n) {
		int count=0;
		
		HashMap<Integer, Integer> map=new HashMap<>();
		//set.add(0);
		
		int prefixSum=0;
		
		for(int i=0;i<n;i++) {
			prefixSum+= arr[i];
			
			if(prefixSum ==0)
				count++;
			
				map.computeIfPresent(prefixSum, (k,v) -> v+1);
				map.computeIfAbsent(prefixSum, (k)-> 1);
			
		}
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			if(entry.getValue() >1) {
				count+= ((entry.getValue() * (entry.getValue()-1))/2);
			}
		}
		System.out.println(count);
	}

}
