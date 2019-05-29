package com.example.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class RomanToInteger {
	
	enum Roman{
		I(1), V(5), X(10), L(50), C(100), D(500), M(1000);
		
		private int value;
		
		private Roman(int value) {
			this.value= value;
		}
		
		public int getValue() {
			return value;
		}
	}
	static HashMap<Character, Integer> romanMap=new HashMap<>();
	static {
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		
		while(t-->0) {
			String str= s.next();
			RomanToInteger obj=new RomanToInteger();
			
			System.out.println(obj.convertRomanToDec(str));
		}
		
		s.close();
	}
	
	static boolean addSubFlag= true;
			
	private int convertRomanToDec(String st) {
		int num=0;
		StringBuilder str=new StringBuilder(st);
		
		
		
		int maxInd=0;
		int maxValue= romanMap.get(str.charAt(0));
		
		for(int i=1;i< str.length();i++) {
			if(romanMap.get(str.charAt(i)) > maxValue) {
				maxInd= i;
				maxValue= romanMap.get(str.charAt(i));
			}
		}
		
		
		
		if(maxInd!=0 )
			addSubFlag= false;
		
		num+= maxValue;
		str.deleteCharAt(maxInd);
		
		while(str.length()>0) {
		
		int maxIndex=findMaxIndex(str);
		
		int v= romanMap.get(str.charAt(maxIndex));
		
		if(addSubFlag)
			num+= v;
		else
			num-= v;
		
		if(maxIndex!=0 )
			addSubFlag= false;
		else
			addSubFlag=true;
		
		str.deleteCharAt(maxIndex);
		}
		return num;
	}

	private int findMaxIndex(StringBuilder str) {
		
		int maxInd=0;
		int maxValue= romanMap.get(str.charAt(0));
		
		for(int i=1;i< str.length();i++) {
			if(romanMap.get(str.charAt(i)) > maxValue) {
				maxInd= i;
				maxValue= romanMap.get(str.charAt(i));
			}
		}
		
		/*if(maxInd!=0 )
			addSubFlag= false;
		else
			addSubFlag= true;*/
		
		return maxInd;
	}

}
