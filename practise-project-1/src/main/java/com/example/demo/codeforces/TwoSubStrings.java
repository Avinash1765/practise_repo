package com.example.demo.codeforces;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoSubStrings {

	public static void main(String[] args) {
		String AB = "AB";
		String BA = "BA";
		
		Scanner s = new Scanner(System.in);
		String str= s.next();
		
		int n=str.length();
		
		Set<Integer> abIndexes= new HashSet<>();
		Set<Integer> baIndexes= new HashSet<>();
		
		for(int i=0;i<n-1;i++) {
			String currString=str.substring(i, i+2);
			if(currString.equals(AB))
				abIndexes.add(i);
			else if(currString.equals(BA))
				baIndexes.add(i);
		}
		
		boolean smallerToIt = abIndexes.size() < baIndexes.size();
		
		if(smallerToIt) {
			for(Integer ele: abIndexes) {
				boolean prevElePresent= baIndexes.remove(ele-1);
				boolean nextElePresent= baIndexes.remove(ele+1);
				
				if(baIndexes.size()>0) {
					System.out.println("YES");
					return;
				}
				if(prevElePresent)
					baIndexes.add(ele-1);
				if(nextElePresent)
					baIndexes.add(ele+1);
			}
		}else {
			for(Integer ele: baIndexes) {
				boolean prevElePresent= abIndexes.remove(ele-1);
				boolean nextElePresent= abIndexes.remove(ele+1);
				
				if(abIndexes.size()>0) {
					System.out.println("YES");
					return;
				}
				if(prevElePresent)
					abIndexes.add(ele-1);
				if(nextElePresent)
					abIndexes.add(ele+1);
			}
		}
		System.out.println("NO");
	}

}
