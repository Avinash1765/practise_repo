package com.example.demo;

import java.util.Scanner;
import java.util.Stack;

public class TrappingRainWater {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		
		while(t-->0) {
		int n=s.nextInt();
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++)
			arr[i]=s.nextInt();
		
		System.out.println(solve(arr,n));
		}
	}

	private static int solve(int[] arr, int n) {
		int largestOnRight[]=null;
		int largestOnLeft[]=null;
		
		largestOnRight=maxElementsOnRight(arr,n);
		largestOnLeft= maxElementsOnLeft(arr,n);
		int sum=0;
		for(int i=0;i<n;i++) {
			if(largestOnLeft[i]==-1 || largestOnRight[i]==-1) {
				sum+=0;
				continue;
			}
			int ele=Math.min(arr[largestOnLeft[i]],arr[largestOnRight[i]]);
			sum+=ele>arr[i]? ele-arr[i] : 0;
		}
		return sum;
	}

	

	private static int[] maxElementsOnRight(int[] arr, int n) {
		int ans[]=new int[n];
		Stack<Integer> stack=new Stack<>();
		stack.push(n-1);
		for(int i=n-2;i>=0;i--) {
			if(arr[i]<arr[stack.peek()]) {
				ans[i]=stack.peek();
				continue;
			}
			stack.push(i);
		}
		while(!stack.isEmpty())
			ans[stack.pop()]=-1;
		
		return ans;
	}
	
	private static int[] maxElementsOnLeft(int[] arr, int n) {
		int ans[]=new int[n];
		Stack<Integer> stack=new Stack<>();
		stack.push(0);
		for(int i=1;i<n;i++) {
			if(arr[i]<arr[stack.peek()]) {
				ans[i]=stack.peek();
				continue;
			}
			stack.push(i);
		}
		while(!stack.isEmpty())
			ans[stack.pop()]=-1;
		
		return ans;
	}
}
