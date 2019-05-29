package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DhruvRiyaz {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		Map<Character, Character> map=new HashMap<>();
		intialize(map);
		while(n-->0) {
			
			char k= s.next().charAt(0);
			char v= s.next().charAt(0);
			char temp1=map.get(v);
			char temp2=map.get(k);
			map.put(k, temp1);
			map.put(v, temp2);
		}
		String str=s.next();
		
		findWhatDhruvTypes(str,map);
	}

	private static void findWhatDhruvTypes(String str, Map<Character, Character> map) {
			StringBuilder finalString =new StringBuilder();
			Map<Character,Character> finalMap=new HashMap<>();
			for(Map.Entry<Character, Character> entry: map.entrySet()) 
				finalMap.put(entry.getValue(), entry.getKey());
			
			
			for(char ch: str.toCharArray()) {
				if(Character.isLowerCase(ch))
					finalString.append(Character.toLowerCase(finalMap.get(Character.toUpperCase(ch))));
				else
					finalString.append(finalMap.get(ch));
			}
			System.out.println(finalString);
	}

	
	
	
	private static void intialize(Map<Character, Character> map) {
		for(char ch='A';ch<='Z';ch++)
			map.put(ch, ch);
		map.put(' ', ' ');
	}

}
