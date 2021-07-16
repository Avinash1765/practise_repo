package com.example.demo.codeforces;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Problem522B {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
			 
			int totalWidth=0;
			int n= s.nextInt();
			int arr[]= new int[n];
			int height[]= new int[n];
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			//Set<Integer> set = new HashSet<>();
			
			for(int i=0;i<n;i++) {
				arr[i]= s.nextInt();
				totalWidth+= arr[i];
				height[i]= s.nextInt();
				maxHeap.add(height[i]);
//				if(!set.contains(height[i])) {
//					set.add(height[i]);
//					maxHeap.add(height[i]);
//				}
			}
			
			for(int i=0;i<n;i++) {
				int heighest=-1;
				long ans= (totalWidth - arr[i]);
				
				if(height[i]== maxHeap.peek()) {
					heighest = maxHeap.poll();
				}
				ans*= maxHeap.peek();
				System.out.print(ans+" ");
				if(heighest!=-1)
					maxHeap.add(heighest);
			}
	}

}
