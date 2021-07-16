package com.example.demo.codeforces;

import java.util.Scanner;

public class RedBlue {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int t= s.nextInt();
		
		while(t-->0) {
			int n= s.nextInt();
			int r[]= new int[n];
			
			for(int i=0;i<n;i++)
				r[i]= s.nextInt();
			
			int m= s.nextInt();
			int b[]= new int[m];
			
			for(int i=0;i<m;i++)
				b[i]= s.nextInt();
			
			int rdp[]= new int[n];
			
			rdp[n-1]= r[n-1];
			
			for(int i=n-2;i>=0;i--) {
				rdp[i]= Math.max(r[i], r[i] + rdp[i+1]);
			}
			
			int bdp[]= new int[m];
			
			bdp[m-1]= b[m-1];
			
			for(int i=m-2;i>=0;i--) {
				bdp[i]= Math.max(b[i], b[i] + bdp[i+1]);
			}
			
			System.out.println(Math.max(Math.max(Math.max(0, rdp[0]), bdp[0]), rdp[0] + bdp[0]));
		}
	}

}
