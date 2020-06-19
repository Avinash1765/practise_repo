package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tournament {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		
		while(t-->0) {
			s.nextInt();
			String a=s.next();
			String b=s.next();
			
			HashMap<Character, Integer> map1=new HashMap<>();
			HashMap<Character, Integer> map2=new HashMap<>();
			
			for(Character ch: a.toCharArray()) {
				map1.compute(ch, (k,v)-> (v==null) ? 1 : v+1);
			}
			
			for(Character ch: b.toCharArray()) {
				map2.compute(ch, (k,v)-> (v==null) ? 1 : v+1);
			}
			int count=0;
			for(Map.Entry<Character, Integer> entry : map1.entrySet()) {
				Integer otherMapCount=map2.get(entry.getKey());
				
				if(otherMapCount!= null)
					count+= Math.min(entry.getValue(), otherMapCount.intValue());
			}
			
			System.out.println(count);
			
		}
	}

}
