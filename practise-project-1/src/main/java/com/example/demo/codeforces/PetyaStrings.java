package com.example.demo.codeforces;

import java.util.Scanner;

public class PetyaStrings {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int ans=0;
		String str1 = s.next();
		String str2 = s.next();
		
		int n= str1.length();
		
		for(int i=0; i<n && ans==0 ;i++) {
			int val1=str1.charAt(i);
			int val2=str2.charAt(i);
			
			if(val1 >= 65 && val1 <=90)
				val1+= 32;
			
			if(val2 >= 65 && val2 <=90)
				val2+= 32;
			
			
			ans= Integer.signum(val1 - val2);
		}
		
		System.out.println(ans);
	}

}
