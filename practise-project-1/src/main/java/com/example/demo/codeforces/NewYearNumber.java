package com.example.demo.codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class NewYearNumber {
	
	int[] dp;
	
	public NewYearNumber() {
		dp=new int[1000000];
		Arrays.fill(dp, -1);
	}
	
	public static void main(String[] args) {
		
		NewYearNumber obj= new NewYearNumber();
		
		Scanner s=new Scanner(System.in);
		int t= s.nextInt();
		
		while(t-->0) {
			int ele= s.nextInt();
			if(ele==0) {
				System.out.println("NO");
				continue;
			}
			System.out.println(obj.findAns(ele) ? "YES" : "NO");
		}
	}

	private boolean findAns(int n) {
		
		if(n<0)
			return false;
		if(n==0)
			return true;
		if(dp[n]!=-1)
			return true;
		if(findAns(n-2020) || findAns(n-2021)) {
			dp[n]=1;
			return true;
		}
		return false;
	}
}
