package com.example.demo;

import java.util.Scanner;

public class ExcelColumnNumber {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		
		while(t-->0) {
			int n=s.nextInt();
			StringBuilder str=new StringBuilder();
			
			while(n>0) {
				if(n%26 == 0) {
					str.append('Z');
					n= (n/26)-1;
				}
				else {
					str.append((char)(64 + (n%26)));
					n/=26;
				}
			}
			
			System.out.println(str.reverse());
		}
	}

}
