package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FindSubSequences {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		Map<Integer, Integer> map=new TreeMap<>();
		map.get
		while(n-->0) {
			int ele=s.nextInt();
			map.computeIfPresent(ele, (k,v)-> v+1);
			map.computeIfAbsent(ele, (k) -> 1);
		}
		Collection<Integer> coll=map.values();
		//int max= Integer.MAX_VALUE;
		//boolean isSorted=true;
		//int i=1;
		
		List<Integer> lis= new ArrayList<>(map.keySet());
		Collections.reverse(lis);
		int maxEle=lis.iterator().next();
		int numElementsToAdd=0;
		boolean isPrintable= true;
		for(int i=1;i<maxEle;i++) {
			
			if(map.get(i)==null) {
				isPrintable= false;
				for(int j=i+1;j<=maxEle;j++) {
					if(map.get(j)!=null) {
						int el=map.get(j);
						numElementsToAdd+= el;
						map.put(i, el);
						break;
					}
						
				}
			}
		}

for(int i=1;i<maxEle;i++) {
		if(map.get(i)<map.get(i+1)) {
			isPrintable= false;
			numElementsToAdd+= map.get(i+1)- map.get(i);			
		}
}

		if(!isPrintable)
			System.out.println(numElementsToAdd);
		else {
			ArrayList<ArrayList<Integer>> toPrint=new ArrayList<ArrayList<Integer>>();
			while(map.get(1) !=0) {
				ArrayList<Integer> list=new ArrayList<>();
				for(int key: map.keySet()) {
					if(map.get(key)>0) {
						list.add(key);
						map.put(key, map.get(key)-1);
					}
				}
				toPrint.add(list);
		}
			
			Collections.reverse(toPrint);
			System.out.println(toPrint.size());
			for(ArrayList<Integer> li:toPrint) {
				for(int ele: li) {
					System.out.print(ele+" ");
				}
				System.out.println();
			}
		}
			
		/*
		
		for(Map.Entry<Integer, Integer> entries: map.entrySet()) {
			while(i<=maxEle)
			if(ele>max) {
				isSorted=false;
				break;
			}
			max=ele;
		}*/
		
		/*ArrayList<ArrayList<Integer>> toPrint=new ArrayList<ArrayList<Integer>>();
		if(isSorted) {
			while(map.get(1) !=0) {
				ArrayList<Integer> list=new ArrayList<>();
				for(int key: map.keySet()) {
					if(map.get(key)>0) {
						list.add(key);
						map.put(key, map.get(key)-1);
					}
				}
				toPrint.add(list);
		}
			
			Collections.reverse(toPrint);
			for(ArrayList<Integer> lis:toPrint) {
				for(int ele: lis) {
					System.out.print(ele+" ");
				}
				System.out.println();
			}
	}
		else {
			List<Integer> lis= new ArrayList<>(map.keySet());
			Collections.reverse(lis);
			int maxEle=lis.iterator().next();
			
			for(int i=1;i<=maxEle; i++) {
				if(map.get(i)==null) {
					
				}
			}
		}*/
	}
}
