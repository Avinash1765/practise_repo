package com.example.demo;

import java.util.Scanner;
import java.util.TreeSet;

public class EasySumSetProblem {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		int ar[]=new int[a];
		
		for(int i=0;i<a;i++)
			ar[i]=s.nextInt();
		
		int st=s.nextInt();
		int sr[]=new int[st];
		
		for(int i=0;i<st;i++)
			sr[i]=s.nextInt();
		TreeSet<Integer> set=new TreeSet<>();
		for(int i=0;i<st;i++) {
			for(int j=0;j<a;j++) {
				set.add(sr[i]-ar[j]);
			}
		}
		
		for(int ele: set) {
			System.out.println(ele+" ");
		}
		
	}

}
