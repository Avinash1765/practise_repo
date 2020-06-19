package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IntegerToRoman {
	
	static final StringBuilder str=new StringBuilder(); 
	
	static HashMap<Character, Integer> romanMap=new HashMap<>();

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);
		
		int t=s.nextInt();
		
		while(t-->0) {
			int num=s.nextInt();
			
			convertToRoman(num);
			System.out.println(str);
		}
	}

	private static void convertToRoman(int num) {
		
		boolean appendLeftRightFlag= true;
		
		while(num>0) {
			if(num==3) {
				str.append("III");
				num-=3;
				continue;
		}
			Map.Entry<Character, Integer> nearestEntry= null;
			
			int minDiff=Integer.MAX_VALUE;
			
			for(Map.Entry<Character, Integer> entry : romanMap.entrySet()) {
				if(Math.abs(entry.getValue()- num) < minDiff) {
					nearestEntry= entry;
					minDiff= Math.abs(entry.getValue()- num);
				}
			}
			
			if(str.length() ==0) {
				str.append(nearestEntry.getKey());
				if(num - nearestEntry.getValue() >0)
					appendLeftRightFlag= false;
				num= Math.abs(nearestEntry.getValue()- num);
				continue;
			}
			
			if(appendLeftRightFlag)
				str.insert(0, nearestEntry.getKey());
			else
				str.append(nearestEntry.getKey());
			
			if(num - nearestEntry.getValue() >0)
				appendLeftRightFlag= false;
			else
				appendLeftRightFlag=true;
			
			num= Math.abs(nearestEntry.getValue()- num);
	}

}}
