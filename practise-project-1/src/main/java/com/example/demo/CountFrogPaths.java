package com.example.demo;

import java.util.Scanner;

public class CountFrogPaths {

	public static void main(String[] args) {
		Scanner s1=new Scanner(System.in);
		
		int x=s1.nextInt();
		int y=s1.nextInt();
		int s=s1.nextInt();
		int t=s1.nextInt();
		
		int count=1;
		t-= x+y;
		
		if(t>0) {
			for(int i=0;i<s;i++) {
				for(int j=0;j<s;j++) {
					if(i+j <= t)
						count++;
				}
			}
		}
		System.out.println(count);
	}

}
