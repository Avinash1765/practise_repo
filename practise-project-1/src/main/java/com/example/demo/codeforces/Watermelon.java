package com.example.demo.codeforces;

import java.util.Scanner;

public class Watermelon {
		public static void main(String[] args) {
			Scanner s=new Scanner(System.in);
			
			int n= s.nextInt();
			
			if(n==2)
				System.out.println("NO");
			else
				System.out.println((n%2==0 ? "YES" : "NO"));
		}
}
