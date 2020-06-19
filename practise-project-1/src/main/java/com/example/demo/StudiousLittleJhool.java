package com.example.demo;

import java.util.Scanner;

public class StudiousLittleJhool {

	public static void main(String[] args) {
		int dp[]=new int[114];
		
		for(int i=1;i<=113;i++) {
			int val1=0, val2=0;
			
			if(i%2 ==1 || i<10) {
				dp[i]=-1;
			}else {
				int ele=i;
				if((ele-10)>=0 && dp[ele-10]!=-1) {
					val1= dp[ele-10]+1;
				}
				if((ele-12)>=0 && dp[ele-12]!=-1) {
					val2= dp[ele-12]+1;
				}
			}
			
			if(val1==0 && val2==0)
				dp[i]=-1;
			else if(val1==0 && val2!=0)
				dp[i]+= val2;
			else if(val1!=0 && val2==0)
				dp[i]+= val1;
			else
				dp[i]+= Math.min(val1, val2);
			
		}
		
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
			System.out.println(dp[s.nextInt()]);
		}
		
	}

}
