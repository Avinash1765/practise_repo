package com.example.demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FlatEarthSociety {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Queue<Integer> q=new LinkedList<>();
		int t=s.nextInt();
		
		while(t-->0) {
			int n=s.nextInt();
			int l=s.nextInt();
			int r=s.nextInt();
			
			String str[]=s.nextLine().split(" ");
			
			int arr[]=new int[n];
			
			for(int i=0;i<n;i++)
				arr[i]=Integer.parseInt(str[i]);
			
			
		}
	}

}
