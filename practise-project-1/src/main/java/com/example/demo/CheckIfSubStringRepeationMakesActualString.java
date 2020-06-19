package com.example.demo;

import java.util.Scanner;

public class CheckIfSubStringRepeationMakesActualString {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		
		while(n-->0) {
			String str=s.next();
			int m=str.length();
			
			int arr[]=new int[m];
			
			int len=0;
			int i=1;
			int max=arr[0];
			
			while(i<m) {
				if(str.charAt(i) == str.charAt(len)) {
					arr[i]=++len;
					i++;
				}else {
					if(len==0) {
						arr[i++]=len;
					}else {
						len=arr[len-1];
					}
				}
			}
			
			int val=arr[m-1];
			
			String ans;
			ans=(val!=0 && m%(m-val)==0) ? "TRUE": "FALSE";
			System.out.println(ans);
	
	}
	}
}
