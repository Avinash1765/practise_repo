package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedleintheHaystack {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		
		while(t-->0) {
			String pattern = s.next();
			String str= s.next();
			boolean flag=false;
			int patternLength= pattern.length();
			
			Map<Character, Integer> patternMap=new HashMap<>();
			
			for(char ch: pattern.toCharArray()) {
				patternMap.computeIfPresent(ch, (k,v)-> v+1);
				patternMap.computeIfAbsent(ch, k -> 1);
			}
			
			int strLength= str.length();
			
			String text=str.substring(0,patternLength);
			
			Map<Character, Integer> textMap=new HashMap<>();
			
			for(char ch: text.toCharArray()) {
				textMap.computeIfPresent(ch, (k,v)-> v+1);
				textMap.computeIfAbsent(ch, k -> 1);
			}
			
			if(patternMap.equals(textMap)) {
				System.out.println("YES");
				flag=true;
			}else {
			for(int i=patternLength;i < strLength; i++) {
				char c=str.charAt(i-patternLength);
				char c2= str.charAt(i);
				
				textMap.compute(c2, (k, v) -> (v == null) ? 1 : v+1);
				
				int val=textMap.get(c);
				
				if(val==1)
					textMap.remove(c);
				else
					textMap.put(c, val-1);
				
				
				if(patternMap.equals(textMap)) {
					System.out.println("YES");
					flag= true;
				}
			}
			
		}
			
			if(!flag)
				System.out.println("NO");
		}
	}

}
