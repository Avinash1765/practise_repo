package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ICPC {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		
		while(t-->0) {
			int n=s.nextInt();
			int k=s.nextInt();
			int arr[]=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=s.next().length();
			}
			
			Map<Integer, Integer> map=new HashMap<>();
			
			for(int i=0;i<n;i++) {
				map.computeIfPresent(arr[i], (ke,v)-> v+1);
				map.computeIfAbsent(arr[i], ke-> 1);
			}
			
			Predicate<Integer> intPredicate= (ele) -> ele%k!= 0;
			int size=map.values().stream().filter(intPredicate).collect(Collectors.toList()).size();
			
			if(size>0)
				System.out.println("Not possible");
			else
				System.out.println("Possible");
			
	}
	}

}
