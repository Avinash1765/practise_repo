package com.example.demo.codeforces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Problem1451B {

	public static void main(String[] args) {
		Scanner  s=new Scanner(System.in);
		int t= s.nextInt();
		
		while(t-->0) {
			int n= s.nextInt();
			int q= s.nextInt();
			char arr[]= s.next().toCharArray();
			
			while(q-->0) {
				int l= s.nextInt();
				int r= s.nextInt();
				
				if(!checkLeft(l, r, arr) && !checkRight(l, r, arr, n)) {
					System.out.println("NO");
					continue;
				}
				System.out.println("YES");
				
			}
		}
	}

	private static boolean checkRight(int l, int r, char[] arr, int n) {
		char baseRightChar = arr[r-1];
		
		for(int i=r;i<n;i++) {
			if(arr[i]== baseRightChar)
				return true;
		}
		return false;
	}

	private static boolean checkLeft(int l, int r, char[] arr) {
		char baseLeftChar = arr[l-1];
		
		for(int i=0;i<l-1;i++) {
			if(arr[i]== baseLeftChar)
				return true;
		}
		
		return false;
	}

}
