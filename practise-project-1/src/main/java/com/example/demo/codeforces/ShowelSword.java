package com.example.demo.codeforces;

import java.util.Scanner;

public class ShowelSword {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t= s.nextInt();
		
		while(t-->0) {
			long a= s.nextLong();
			long b= s.nextLong();
			
			if(a>b) {
				long temp= b;
				b=a;
				a= temp;
			}
			
			if(a==0 || b==0) {
				System.out.println(0);
				continue;
			}

			System.out.println(findAns(a, b));
					
			
		}
	}
	
	public static long findAns(long a, long b) {
		if(b >= 2*a)
			return a;
		else if(b==a) 
			return (((b/3)*2) + ((b%3 == 2) ? 1 : 0));
		else
			return (b-a) + findAns((2*a)-b, (2*a)-b);
	}

}
