package com.example.demo.codeforces;

import java.util.Scanner;

public class MakeItGood {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		int t= s.nextInt();
		
		while(t-->0) {
			int n= s.nextInt();
			int[] arr= new int[n];
			
			for(int i=0;i<n;i++)
				arr[i]= s.nextInt();
			
			
			int ans=0;
			
			int incSeqBefore= 0;
			int ind=1;
			
			while(ind <n) {
				if(arr[ind] >= arr[ind-1]) {
					ans= ind-1;
					while( ind <n && arr[ind] >= arr[ind-1]) {
						ind++;
					}
				}
				else
					ind++;
				
			}
			
			System.out.println(ans);
		}
	}

}
