package com.example.demo.codeforces;

import java.util.Scanner;

public class StonesOnTable {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		int n= s.nextInt();
		String str= s.next();
		int ans=0;
		
		for(int i=0; i< n-1; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}

}
