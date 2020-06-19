package com.example.demo;

import java.util.Scanner;
import java.util.Stack;

public class MonkAndPrisoner {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++)
			arr[i]=s.nextInt();
		
		int nge[]=NGE(arr,n);
		int nse[]=NSE(arr,n);
		
		int ans[]=solve(nge,nse,n,arr);
		
		for(int i=0;i<n;i++)
			System.out.print(ans[i]+" ");
	}

	private static int[] solve(int[] nge, int[] nse, int n,int arr[]) {
		int ans[]=new int[n];
		
		for(int i=0;i<n;i++) {
			if(nge[i]==-1) {
				ans[i]=-1;
				continue;
			}
			if(nse[nge[i]]==-1) {
				ans[i]=-1;
				continue;
			}
			else
				ans[i]=arr[nse[nge[i]]];
		}
		
		return ans;
	}

	private static int[] NGE(int[] arr, int n) {
		int ans[]=new int[n];
		
		Stack<Integer> stack=new Stack<>();
		
		for(int i=arr.length-1;i>=0;i--) {
				if(!stack.isEmpty()) {
					while(!stack.isEmpty() && (arr[stack.peek()])<=arr[i])
						stack.pop();
				}
				ans[i]= stack.empty() ? -1: stack.peek();
				stack.push(i);
		}
		return ans;
	}
	
	private static int[] NSE(int[] arr, int n) {
		int ans[]=new int[n];
		
		Stack<Integer> stack=new Stack<>();
		
		for(int i=arr.length-1;i>=0;i--) {
				if(!stack.isEmpty()) {
					while(!stack.isEmpty() && (arr[stack.peek()])>=arr[i])
						stack.pop();
				}
				ans[i]= stack.empty() ? -1: stack.peek();
				stack.push(i);
		}
		return ans;
	}

}
