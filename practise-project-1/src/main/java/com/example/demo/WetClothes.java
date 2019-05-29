package com.example.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class WetClothes {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		int g=s.nextInt();
		
		int time[]=new int[n-1];
		int prev=s.nextInt();
		
		for(int i=0;i<n-1;i++) {
			int ele = s.nextInt();
			time[i] = ele - prev;
			prev = ele;
		}
		
		
		
		int dry[]=new int[m];
		
		for(int i=0;i<m;i++)
			dry[i]=s.nextInt();
		
		int maxInterval= Integer.MIN_VALUE;
		
		for(int i=0;i<n-1;i++) {
			if(time[i] > maxInterval)
				maxInterval= time[i];
		}
		int count=0;
		for(int i=0;i<m;i++) {
			if(dry[i]<= maxInterval)
				count++;
		}
		System.out.println(count);
		
		
		
		
		//boolean visited[]=new boolean[m];
		
			/*for(int i=n-2;i>=0 && g-->0;i--) {
				for(int j=0;j<m;j++) {
					
				}
			}*/
		
		
		
	}

}
