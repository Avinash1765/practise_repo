package com.example.demo;

import java.util.Scanner;

public class PermuteString {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		
		while(t-->0) {
			String str=s.next();
			String answer="";
			permuteString(str, answer, str.length());
		}
	}

	private static void permuteString(String str, String answer, int len) {
		if(answer.length() == len) {
			System.out.println(answer);
			return;
		}
		
		for(int i=0;i<str.length();i++) {
			
			char ch= str.charAt(i);
			
			permuteString(str.substring(0, i) + str.substring(i+1), answer + ch,len);
		}
	}

}
