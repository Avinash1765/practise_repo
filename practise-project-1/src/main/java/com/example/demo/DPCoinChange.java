package com.example.demo;

import java.util.Arrays;
import java.util.Scanner;

// counts no of ways with given denominations 
public class DPCoinChange {

	public static void main(String[] args) {

		int numCoins;
		Scanner s=new Scanner(System.in);
		
		int testCases=s.nextInt();
		
		while(testCases>0) {
		numCoins=s.nextInt();
		int coin[]=new int[numCoins];
		
		for(int i=0;i<numCoins;i++)
			coin[i]=s.nextInt();
		
		Arrays.sort(coin);
		
		int amount=s.nextInt();
		
		
		countWays(coin, amount);
		testCases--;
		}
	}

	private static void countWays(int[] coin, int amount) {
		int arr[][]=new int[coin.length][amount];
		
		
			for(int j=0;j<coin.length;j++) {
					for(int i=1;i<=amount;i++) {
				
			if(j==0) {
				if(j==0 && coin[j]>i)
					arr[j][i-1]=0;
				
				if(j==0 && i%coin[j]==0)
					arr[j][i-1]=1;
			}else {
				int excludedCase= arr[j-1][i-1];
				int includedCase=0;
				if(i-coin[j]<0)
					includedCase=0;
				else if(i-coin[j]==0)
					includedCase=1;
				else
					includedCase=arr[j][i-coin[j]-1];
				
				arr[j][i-1]=excludedCase+includedCase;
					
				
			}
		}
	}
			System.out.println(arr[coin.length-1][amount-1]);
}
}
