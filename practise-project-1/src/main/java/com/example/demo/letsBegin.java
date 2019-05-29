package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class letsBegin {
	public static void main(String[] args) {
		 Scanner s=new Scanner(System.in);
		 
		 int t=s.nextInt();
		 
		 long arr[]=new long[10000001];
		 
		 populateArray(arr);
		 
		 while(t-->0) {
			 int num=s.nextInt();
			 
			 System.out.println(arr[num]);
		 }
	}

	private static void populateArray(long[] arr) {
		
		arr[1]=-1;
		arr[2]=1;
		arr[3]=1;
		arr[4]=2;
		arr[5]=1;
		arr[6]=2;
		arr[7]=1;
		
		ArrayList<Long> list=new ArrayList<>();
		
		for(int i=8;i<=1000_000;i++) {
			
			if(arr[i-2]!=-1)
				list.add(arr[i-2]);
			if(arr[i-3]!=-1)
				list.add(arr[i-3]);
			if(arr[i-5]!=-1)
				list.add(arr[i-5]);
			if(arr[i-7]!=-1)
				list.add(arr[i-7]);
			
			if(list.isEmpty())
				arr[i]=-1;
			else
				arr[i]=Collections.min(list)+1;
			
			list.clear();
		}
		
	}
}
