package com.example.demo.codeforces;

import java.util.Scanner;

public class DivisibilityBy8 {

	public static void main(String[] args) {
		Scanner  s=new Scanner(System.in);
		
		String str=s.next();
		int n= str.length();
		
		int arr[]= new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]= str.charAt(i) - 48;
		}
		
		buildMap()
	}

}
