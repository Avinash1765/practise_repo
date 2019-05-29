package com.example.demo;

import java.util.Scanner;

public class KKCrush {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
			int n=s.nextInt();
			boolean arr[]=new boolean[2000001];
			while(n-->0) {
				int ele=s.nextInt();
				if(ele>0)
					arr[ele]=true;
				else
					arr[100000+(-1*ele)]=true;
			}
			int q=s.nextInt();
			while(q-->0) {
				int ele=s.nextInt();
				if(ele>=0) {
					if(arr[ele])
						System.out.println("Yes");
					else
						System.out.println("No");
				}else {
					if(arr[100000 + (-1*ele)])
						System.out.println("Yes");
					else
						System.out.println("No");
				}
					
				
			}
		}
	}

}
