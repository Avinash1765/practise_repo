package com.example.demo;

import java.util.Scanner;

public class MonkAndGraphFactory {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		int max=Integer.MIN_VALUE;
		
		while(n-->0) {
			int ele=s.nextInt();
			if(ele > max)
				max=ele;
		}
		
		if(max>=n)
			System.out.println("No");
		else
			System.out.println("YES");
	}

}
