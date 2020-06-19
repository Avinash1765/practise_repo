package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class LittleJhoolandthematchmaker {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Character arr[]={'l','i', 't', 'e', 'j','h','o'};
		Set<Character> jhoolSet=new HashSet<>(Arrays.asList(arr));
		
		int t=s.nextInt();
		
		while(t-->0) {
			int n=s.nextInt();
			int k=s.nextInt();
			Map<Integer, ArrayList<String>> map=new TreeMap<>();
			while(n-->0) {
				String str= s.next();
				int count=0;
				Character ar[]=new Character[str.length()];
				int j=0;
				for (char c: str.toCharArray()) {
					ar[j++]=Character.toLowerCase(c);
				}
				
				Set<Character> inputName=new HashSet<>(Arrays.asList(ar));
				for(char ch: inputName) {
					if(jhoolSet.contains(ch))
						count++;
				}
				map.computeIfPresent(count, (ke,v) -> {v.add(str); return v;});
				map.computeIfAbsent(count, ke->{ArrayList<String> l= new ArrayList<>(); l.add(str); return l;});
			}
			
			for(ArrayList<String> list: map.values()) {
				for(String st: list) {
					if(k>0) {
						System.out.print(st+" ");
						k--;
					}
					//break;
				}
			}
			System.out.println();
		}
		
	}

}
