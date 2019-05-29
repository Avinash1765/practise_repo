package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class XsquareAndPalindromesInsertion {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		while(n-->0) {
			String str=s.next();
			Map<Character,Integer> map=new HashMap<>();
			for(Character ch : str.toCharArray()) {
				map.computeIfPresent(ch, (k,v)-> v+1);
				map.computeIfAbsent(ch, k -> 1);
			}
			AtomicInteger oddCount=new AtomicInteger(0);
			AtomicInteger evenCount=new AtomicInteger(0);
			map.entrySet().forEach(obj -> {
				if(obj.getValue()%2==0)
					evenCount.getAndIncrement();
				else
					oddCount.getAndIncrement();
			});
			int oddC=oddCount.get();
			int evenC= evenCount.get();
			
			System.out.println(oddC<=1 ? 0 : oddC-1);
		}
	}

}
