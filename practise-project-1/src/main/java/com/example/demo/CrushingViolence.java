package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CrushingViolence {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		
		while(t-->0) {
			int n=s.nextInt();
			Map<Integer, Integer> boyBeatingsMap=new HashMap<>();
			Map<Integer, Integer> girlBeatingsMap=new HashMap<>();
			
			int boy[]=new int[n+1];
			int girl[]=new int[n+1];
			
			Map<Integer,Integer> boyBeatCountMap=new LinkedHashMap<>();
			Map<Integer,Integer> girlBeatCountMap=new LinkedHashMap<>();
			
			for(int i=1;i<=n;i++) {
				boy[i]=s.nextInt();
			}
			
			for(int i=1;i<=n;i++) {
				girl[i]=s.nextInt();
			}
			
			for(int i=1;i<=n;i++) {
				int ele=girl[boy[i]];
				if(!(ele==i))
					boyBeatingsMap.put(i,ele);
			}

			for(int i=1;i<=n;i++) {
				int ele=boy[girl[i]];
				if(!(ele==i))
					girlBeatingsMap.put(i,ele);
			}
			
			Collection<Integer> list=boyBeatingsMap.values();
			
			for(int item: list) {
				boyBeatCountMap.computeIfPresent(item, (k,v)-> v+1);
				boyBeatCountMap.computeIfAbsent(item, k-> 1);
			}
			
			Collection<Integer> lis2=girlBeatingsMap.values();
			
			for(int item: lis2) {
				girlBeatCountMap.computeIfPresent(item, (k,v)-> v+1);
				girlBeatCountMap.computeIfAbsent(item, k-> 1);
			}
			int boymax=0;
			try {
				boymax=Collections.max(boyBeatCountMap.values());
			}catch(NoSuchElementException e) {
			}
			
			int girlmax=0;
			try {
				girlmax=Collections.max(girlBeatCountMap.values());
			}catch(NoSuchElementException e) {
			}
			
			System.out.print(Math.max(boymax, girlmax)+" ");
			int pairCount=0;
			for(Map.Entry<Integer, Integer> boyBeatingEntry: boyBeatingsMap.entrySet()) {
				if(boyBeatingEntry.getKey()== boyBeatingsMap.get(boyBeatingEntry.getValue()))
					pairCount++;
			}
			
			for(Map.Entry<Integer, Integer> girlBeatingEntry: girlBeatingsMap.entrySet()) {
					if(girlBeatingEntry.getKey()== girlBeatingsMap.get(girlBeatingEntry.getValue()))
						pairCount++;
			}
			
			System.out.println(pairCount/2);
			
			
			/*for(Map.Entry<Integer, Integer> boyCrushEntry: boyCrushMap.entrySet()) {
				int temp=girlCrushMap.get(boyCrushEntry.getValue());
				if(temp == boyCrushEntry.getKey())
					continue;
				boyBeatingsMap.put(boyCrushEntry.getKey(), new Node15(temp));
			}
			
			for(Map.Entry<Integer, Integer> girlCrushEntry: girlCrushMap.entrySet()) {
				int temp=boyCrushMap.get(girlCrushEntry.getValue());
				if(temp == girlCrushEntry.getKey())
					continue;
				girlBeatingsMap.put(girlCrushEntry.getKey(), new Node15(temp));
			}
			Set<Node15> boyNodes=new TreeSet<>(new Node15Comparator());
			Set<Node15> girlNodes=new TreeSet<>(new Node15Comparator());
			boyNodes.addAll(boyBeatingsMap.values());
			girlNodes.addAll(girlBeatingsMap.values());
			
			int boyMaxBeatings=boyNodes.iterator().next().numberOfBeatings;
			int girlMaxBeatings=girlNodes.iterator().next().numberOfBeatings;
			
			System.out.print(Math.max(boyMaxBeatings, girlMaxBeatings)+" ");
			int pairBeatings=0;
			for(Map.Entry<Integer, Node15> boyBeatingEntry: boyBeatingsMap.entrySet()) {
				for(int boyBeater : boyBeatingEntry.getValue().beatThese) {
					if(boyBeatingsMap.get(boyBeater)!=null && boyBeatingsMap.get(boyBeater).beatThese.contains(boyBeatingEntry.getKey()))
						pairBeatings++;
				}
			}
			
			for(Map.Entry<Integer, Node15> girlBeatingEntry: girlBeatingsMap.entrySet()) {
				for(int girlBeater : girlBeatingEntry.getValue().beatThese) {
					if(girlBeatingsMap.get(girlBeater)!=null && girlBeatingsMap.get(girlBeater).beatThese.contains(girlBeatingEntry.getKey()))
						pairBeatings++;
				}
			}
			System.out.println(pairBeatings/2);*/
		}
	}

}
