package com.example.demo.codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class YoungExplorers {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int t= s.nextInt();
		
		while(t-->0) {
			int n= s.nextInt();
			
			int arr[]= new int[n];
			
			for(int i=0;i<n;i++)
				arr[i]= s.nextInt();
			
			Arrays.sort(arr);
			
			int cnt=0, gsi, gei, groupSize;
			
			for(int i=0;i<n;i++) {
				gsi=i;
				groupSize= arr[gsi];
				
				gei= gsi + groupSize-1;
				
				
				while(gei<n && arr[gei] > groupSize) {
					if((gei+1) >= n)
						break;
					groupSize= arr[gei+1];
					gei = gsi + groupSize -1;
				}
				
				if(gei<n && arr[gei]<= groupSize)
					cnt++;
				i= gei;
			}
			System.out.println(cnt);
		}
		
		
	}

}
