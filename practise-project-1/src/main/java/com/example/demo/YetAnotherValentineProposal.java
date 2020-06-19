package com.example.demo;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class YetAnotherValentineProposal {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
	    int n=s.nextInt();
	    int q=s.nextInt();
	    String str=s.next();
	    while(q-->0) {
	    	int l=s.nextInt();
	    	int r=s.nextInt();
	    	Map<Character, Integer> map=new TreeMap<>();
	    	StringBuilder builder =new StringBuilder();
	    	for(char ch='a';ch<='z';ch++)
	    		map.put(ch, 0);
	    	
	    	for(char ch: str.substring(l-1, r).toCharArray()) 
	    		map.computeIfPresent(ch, (k,v)-> v+1);
	    	
	    	for(Map.Entry<Character, Integer> entry: map.entrySet()) {
	    		builder.append((char)((entry.getValue()%26)+1+96));
	    	}
	    	
	    	String finalString= builder.toString();
	    	
	    	int arr[]=buildLPSArray(finalString);
	    	
	    	if(arr[25]==0)
	    		System.out.println("None");
	    	else
	    		System.out.println(finalString.substring(0,arr[25]));
	    }
	}

	private static int[] buildLPSArray(String finalString) {
		
		int arr[]=new int[26];
		
		int i=0;
		int j=1;
		
		while(j<26) {
			
			if(finalString.charAt(j) == finalString.charAt(i)) {
				arr[j]=++i;
				j++;
			}
			else {
				if(i!=0) {
					i= arr[i-1];
				}
				else {
					arr[j]=i;
					j++;
				}
			}
		}
		return arr;
	}

}
