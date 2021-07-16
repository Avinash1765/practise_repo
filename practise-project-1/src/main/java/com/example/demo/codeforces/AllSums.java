package com.example.demo.codeforces;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AllSums {
	static Set<String> set= new HashSet<>();
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();

		String ans = "";

		allSums(n, ans);
		
		for(String finalAnsStr : set) {
			printStr(finalAnsStr);
		}
	}

	private static void allSums(int n, String ans) {
		
		
		if(n==0) {
			char[] chArr = ans.toCharArray();
			Arrays.sort(chArr);
			set.add(new String(chArr));
			return;
		}
		
		if(n==1) {
			allSums(n-1, ans.concat("1"));
			return;
		}
		
		for(int i=1;i< n;i++) {
			
			allSums(n-i, ans.concat(new String(new Integer(i).toString())));
		}
	}

	private static void printStr(String ans) {
		for (char ch : ans.toCharArray()) {
			System.out.print(ch + " ");
		}
		System.out.println();
	}

}

class MyStr {

	private String str;

	public MyStr(String ans) {
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public boolean equals(Object obj) {

		MyStr otherObj = (MyStr) obj;

		Map<Character, Integer> otherObjFreq = getFreq(otherObj.getStr());
		Map<Character, Integer> currentObjFreq = getFreq(this.str);

		return otherObjFreq.equals(currentObjFreq);

	}

	public int hashCode() {

		int finalHashCode = 0;

		Map<Character, Integer> currentObjFreq = getFreq(this.str);

		for (Map.Entry<Character, Integer> entry : currentObjFreq.entrySet()) {
			finalHashCode += ((int) entry.getKey() * entry.getValue());
		}

		return finalHashCode;
	}

	private Map<Character, Integer> getFreq(String str) {

		Map<Character, Integer> charFreq = new HashMap<>();

		for (Character ch : str.toCharArray()) {
			charFreq.computeIfPresent(ch, (c, cnt) -> cnt + 1);
			charFreq.computeIfAbsent(ch, c -> 1);
		}

		return charFreq;
	}

}
