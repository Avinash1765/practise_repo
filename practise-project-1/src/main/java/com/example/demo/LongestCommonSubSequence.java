package com.example.demo;

import java.util.Scanner;

public class LongestCommonSubSequence {

	public static void main(String[] args) {
		int n;
		
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		
		while(n>0) {
			String str1=s.next();
			String str2=s.next();
			
			System.out.println(lcs(str1,str2));
			n--;
		}
	}

	private static int lcs(String first, String second) {
		
		int len1=first.length();
		int len2=second.length();
		
		int arr[][]=new int[len1][len2];
		
		first.ch
		
		
		
		
		return 0;
		
	}
}
