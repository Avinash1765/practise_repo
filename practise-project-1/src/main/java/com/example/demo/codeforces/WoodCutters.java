package com.example.demo.codeforces;

import java.util.Scanner;

public class WoodCutters {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		int n= s.nextInt();
		
		int arr[]=new int[n];
		int h[]= new int[n];
		int lastTreeArr[]= new int[n];
		int count=Math.min(2, n);
		
		lastTreeArr[0]= -1;
		
		for(int i=0;i<n;i++) {
			arr[i]= s.nextInt();
			h[i]= s.nextInt();
		}
		
		for(int i=1;i<n-1;i++) {
			if( (arr[i]-h[i]) > (lastTreeArr[i-1]==1 ? arr[i-1]+h[i-1] : arr[i-1] ) ) {
				count++;
				lastTreeArr[i]=-1;
			}
			else if( (arr[i]+h[i]) < arr[i+1]) {
				count++;
				lastTreeArr[i]= 1;
			}
		}
		
		System.out.println(count);
		
		
		
	}

}
