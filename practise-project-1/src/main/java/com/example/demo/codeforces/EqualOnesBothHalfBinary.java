package com.example.demo.codeforces;

import java.util.Scanner;

public class EqualOnesBothHalfBinary {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		int n= s.nextInt();
		
		String lh= "";
		String rh= "";
		
		generateAllStrs(lh , rh, 0, 0, n );
	}

	private static void generateAllStrs(String a, String b, int l, int r, int n) {
		if(n==0 ) {
			if(l==r)
				System.out.println(a+b);
			return;
		}
		
		generateAllStrs(a+ "0", b + "0", l, r, n-1);
		generateAllStrs(a+ "0", b + "1", l, r+1, n-1);
		generateAllStrs(a+ "1", b + "0", l+1, r, n-1);
		generateAllStrs(a+ "1", b + "1", l+1, r+1, n-1);
		
	}

}
