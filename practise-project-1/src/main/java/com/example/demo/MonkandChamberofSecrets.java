package com.example.demo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MonkandChamberofSecrets {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int x=s.nextInt(),i;
		int tem=n,j=x;
		Queue<Integer> queu= new LinkedList<>();
		
		
		while(tem-->0) {
			queu.add(s.nextInt());
		}
		Queue<Integer> queue= new LinkedList<>(queu);
		int ans[]=new int[x];
		
		for(int k=0;k<x;k++) {
			List<Integer> list=new LinkedList<>();
			int max=Integer.MIN_VALUE;
			int maxInd= -1;
			for(i=0;i<j;i++) {
				int ele=queue.poll();
				if(ele>max) {
					maxInd= i;
					max= ele;
				}
				list.add(ele);
			}
			a
				
		}
	}

}
