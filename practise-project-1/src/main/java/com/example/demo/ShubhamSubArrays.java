package com.example.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


public class ShubhamSubArrays {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		//LinkedHashSet<Integer> se=new LinkedHashSet<>();
		
		int n=s.nextInt();
		Random rand=new Random();
		Integer arr[]=new Integer[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=s.nextInt();
		}
		
		Map<Integer, Long> map=new HashMap<>();
		
		HashSet<Long> set=new HashSet<>();
		
		for(int i=0;i<n;i++) {
			HashSet<Integer> subset=new HashSet<>();
			long sum=0;
			for(int j=i;j<n;j++) {
				long hash;
				if(map.containsKey(arr[j])) {
					hash= map.get(arr[j]);
				}else {
					 hash= arr[j]*rand.nextLong();
					map.put(arr[j], hash);
				}
				
				if(!subset.contains(arr[j])){
					sum += hash;
					set.add(sum);
					subset.add(arr[j]);
				}
				
			}
		}
		
		System.out.println(set.size());
	}

}
