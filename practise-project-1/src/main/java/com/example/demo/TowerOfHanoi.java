package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TowerOfHanoi {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		while(t-->0) {
			int n=s.nextInt();
			List<Node> list=new ArrayList<>();
			int size=n;
			while(n-->0) {
				list.add(new Node(s.nextInt(), s.nextInt()));
			}
			
			Collections.sort(list, new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					return (o1.a < o2.a) ? -1 : 1 ;
				}
			});
			
			long dp[]=new long[size];
			
			for(int i=0;i<size;i++)
				dp[i]=list.get(i).b;
			
			for(int i=1;i<size;i++) {
				Node objI= list.get(i);
				for(int j=0;j<i;j++) {
					Node objJ= list.get(j);
					
					if((objJ.a < objI.a) && (objJ.b < objI.b) && dp[i] < (dp[j]+ objI.b))
						dp[i]= dp[j]+ objI.b;
					
				}
			}
			
			long max=Long.MIN_VALUE;
			
			for(int i=0;i<size;i++) {
				if(dp[i] > max)
					max=dp[i];
			}
			System.out.println(max);
			
		}
	}
	
	static class Node{
		int a, b;
		
		public Node(int a, int b) {
			this.a=a;
			this.b=b;
		}
	}

}
