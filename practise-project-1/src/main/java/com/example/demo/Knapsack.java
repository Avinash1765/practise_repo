package com.example.demo;

import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int items= s.nextInt();
		int maxWeight=s.nextInt();
		
		int weight[]=new int[items];
		
		for(int i=0;i<items;i++)
			weight[i]=s.nextInt();
		
		int value[]=new int[items];
		
		for(int i=0;i<items;i++)
			value[i]=s.nextInt();
		System.out.println(findMaxValue(weight,value,maxWeight));
	}

	private static int findMaxValue(int[] weight, int[] value, int maxWeight) {
		int arr[][]=new int[weight.length][maxWeight+1];
		
		for(int i=0;i<weight.length;i++)
			arr[i][0]=0;
		
		for(int i=1;i<=maxWeight;i++) {
			if(weight[0]>i)
				arr[0][i]=0;
			else
				arr[0][i]=value[0];
		}
		
		for(int i=1;i<weight.length;i++) {
			for(int j=1;j< maxWeight+1;j++) {
				int excludedCase= arr[i-1][j];
				
				int includedCase=0;
				if(weight[i]>j)
					includedCase=0;
				else if(weight[i]==j)
					includedCase= value[i];
				else
					includedCase= value[i]+arr[i-1][j-weight[i]];
				
				arr[i][j]= Math.max(excludedCase, includedCase);
			}
		}
		
		return arr[weight.length-1][maxWeight];
	}

}
