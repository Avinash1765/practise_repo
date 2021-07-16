package com.example.demo.codeforces;

import java.util.Scanner;

public class BalancedParenthesis {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		int n= s.nextInt();
		
		String ans="";
		
		findCombs(ans, n, n);
	}

	private static void findCombs(String ans, int open, int close) {
		if(open < 0 || close <= 0)
			return;
		if(open==0) {
			while(close-->0) {
				ans=ans.concat(")");
			}
			
			System.out.println(ans);
			return;
		}
		
		if(open == close) {
			ans= ans.concat("(");
			findCombs(ans, open-1, close);
			return;
		}
		
		findCombs(ans.concat("("), open-1, close);
		findCombs(ans.concat(")"), open, close-1);
		
		
	}

}
