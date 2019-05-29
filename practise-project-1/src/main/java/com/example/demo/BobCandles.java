package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BobCandles {
	static ArrayList<ArrayList<Integer>> lists=new ArrayList<ArrayList<Integer>>();
	static int arr[];
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
	    int n=s.nextInt();
	    int sum=s.nextInt();
	    arr=new int[n];
	    
	    for(int i=0;i<n;i++)
	    	arr[i]=s.nextInt();
	    
	   boolean dp[][]= buildDPMatrix(arr,n,sum);
	   
	   ArrayList<Integer> list=new ArrayList<>();
	   getAllSetsForSum(dp,n-1, sum,list);
	   ArrayList<ArrayList<Integer>> minLists=new ArrayList<ArrayList<Integer>>();
	   int minSize=Integer.MAX_VALUE;
	   for(ArrayList<Integer> lis: lists) {
		   if(lis.size()<minSize)
			   minSize= lis.size();
	   }
	   
	   for(ArrayList<Integer> lis: lists) {
		   if(lis.size()==minSize)
			   minLists.add(lis);
	   }
	   List<Integer> minList=null;
	   int minute=Integer.MAX_VALUE;
	   for(ArrayList<Integer> lis: minLists) {
		   int su=0;
		   for(Integer ele: lis) {
			   su+=ele;
		   }
		   if(su<minute) {
			   minute=su;
			   minList=lis;
		   }
	   }
	   
	   Set<Integer> treeSet=new TreeSet<>(minList);
	   
	   for(Integer eles: treeSet)
		   System.out.print(eles+" ");
	   
	}

	private static void getAllSetsForSum(boolean[][] dp, int i, int sum, ArrayList<Integer> list) {
		if(i==0 && sum!=0 && dp[0][sum]) {
			list.add(i);
			lists.add(new ArrayList<>(list));
			list.clear();
			return;
		}
		
		if(i==0 && sum==0) {
			lists.add(new ArrayList<>(list));
			list.clear();
			return;
		}
		
		if(dp[i-1][sum]) {
			ArrayList<Integer> b = new ArrayList<>(); 
            b.addAll(list); 
            getAllSetsForSum(dp, i-1, sum, b);
		}
		
		 if (sum >= arr[i] && dp[i-1][sum-arr[i]]) 
	        { 
	            list.add(i); 
	            getAllSetsForSum(dp, i-1, sum-arr[i], list); 
	        }
	}

	private static boolean[][] buildDPMatrix(int[] arr, int n, int sum) {
		boolean dp[][]=new boolean[n][sum+1];
		
		for(int i=0;i<n;i++)
			dp[i][0]=true;
		
		for(int i=1;i<=sum;i++) {
			if(arr[0]==i) {
				dp[0][i]=true;
				break;
			}
		}
		
		for(int i=1;i<n;i++) {
			for(int j=1;j<=sum;j++) {
				dp[i][j]= (arr[i]>j) ? dp[i-1][j] : dp[i-1][j] || dp[i-1][j-arr[i]];
			}
		}
		
		return dp;
		
		
	}

}
