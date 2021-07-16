package com.example.demo.codeforces;

import java.util.Scanner;

public class LCSUsingRecursion {
	static StringBuilder lcsString= new StringBuilder();
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		String a= s.next();
		String b= s.next();
		
		System.out.println(LCS(a,b, a.length()-1, b.length()-1));
		System.out.println(lcsString.reverse());
	}

	private static int LCS(String a, String b, int i, int j) {
		if(i==0) {
			if(b.substring(0, j+1).contains(a.substring(0, 1))) {
				lcsString.append(a.substring(0, 1));
				return 1;
			}else
				return 0;
		}
		
		if(j==0) {
			if(a.substring(0, i+1).contains(b.substring(0, 1))) {
				lcsString.append(b.substring(0, 1));
				return 1;
			}else
				return 0;
		}
		
		if(a.charAt(i) == b.charAt(j)) {
			lcsString.append(new String(new Character(a.charAt(i)).toString()));
			return 1+ LCS(a, b, i-1, j-1);
		}else
			return Math.max(LCS(a, b, i-1, j), LCS(a, b, i, j-1));
	}

}
