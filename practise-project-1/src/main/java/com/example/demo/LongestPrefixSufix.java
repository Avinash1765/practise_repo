package com.example.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LongestPrefixSufix {

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
			
			for(int j=1;j<m;j++) {
				if(arr[j] > max)
					max=arr[j];
			}
			System.out.println(max);
		}
	}

}
