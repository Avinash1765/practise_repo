package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PerfectPair {

	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
	     int t=s.nextInt();
	     
	     while(t-->0) {
	    	 int size=s.nextInt();
	    	 int arr[]=new int[size];
	    	 for(int i=0;i<size;i++)
	    		 arr[i]=s.nextInt();
	    	 countPerfectPairs(arr,size);
	     }
	     s.close();
	}

	private static void countPerfectPairs(int[] arr, int size) {
		//Set<Integer> set=new HashSet<>();
		Map<Integer,Integer> map=new HashMap<>();
		
		
		int max1=Integer.MIN_VALUE;
		int max2= Integer.MIN_VALUE;
		for(int ele: arr) {
			//set.add(ele);
			map.computeIfPresent(ele, (k,v)-> v+1);
			map.computeIfAbsent(ele, (k)-> 1);
			if(ele >=max1) {
				max2=max1;
				max1= ele;
			}
			else if(ele>max2 && ele<max1) {
				max2=ele;
			}
		}
		List<Integer> squareList=new ArrayList<>();
		List<Integer> cubeList=new ArrayList<>();
		int high=max1+max2;
		int i=1;
		while(i*i<=high) {
			squareList.add(i*i);
			i++;
		}
		i=1;
		while(i*i*i<=high) {
			cubeList.add(i*i*i);
			i++;
		}
		int count=0;
		int nc2count=0;
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			for(int square: squareList) {
				if(square-entry.getKey() ==entry.getKey()) {
					nc2count+= nc2(entry.getValue());
					continue;
				}
				if(map.containsKey(square-entry.getKey())) {
					count+= (entry.getValue() * map.get(square-entry.getKey()));
				}
			}
			
			for(int cube: cubeList) {
				if(cube-entry.getKey() ==entry.getKey()) {
					nc2count+= nc2(entry.getValue());
					continue;
				}
				
				if(map.containsKey(cube-entry.getKey())) {
					count+= (entry.getValue() * map.get(cube-entry.getKey()));
				}
			}
		}
		
		System.out.println(nc2count+(count/2));
		
	}

	private static int nc2(Integer n) {
		return (n*(n-1))/2;
	}

}
