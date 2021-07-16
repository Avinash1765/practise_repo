package com.example.demo.codeforces;

import java.util.Scanner;

public class KthBeautifulString {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t= s.nextInt();
		
		while(t-->0) {
		int n= s.nextInt();
		long k = s.nextLong();
		
		int a=0, b=0;
		
		long cnt=0;
		
		boolean breakFlag= false;
		
		for(int i= n-1;i>=1;i--) {
			
			
				/*
				 * for(int j=n;j>i;j--) { ++cnt;
				 * 
				 * if(cnt== k) { a=i; b=j; breakFlag= true; } } if(breakFlag) break;
				 */
		}
		
		StringBuilder str= new StringBuilder();
		
		for(int i=1;i<=n;i++) {
			if(i == a || i==b)
				str.append('b');
			else
				str.append('a');
		}
		
		System.out.println(str);
		}
	}

}
