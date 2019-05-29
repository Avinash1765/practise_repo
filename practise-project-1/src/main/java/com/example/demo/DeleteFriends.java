package com.example.demo;

import java.util.Scanner;
import java.util.Stack;

public class DeleteFriends {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		
		while(t-->0) {
			int n=s.nextInt();
			int k=s.nextInt();
			int arr[]=new int[n];
			
			for(int i=0;i<n;i++) {
				arr[i]=s.nextInt();
			}
			
			Stack<Integer> stack=new Stack<>();
			
			stack.push(arr[0]);
			
			for(int i=1;i<n;i++) {
				if(k==0) {
					stack.push(arr[i]);
				}
				else if(arr[i]<= stack.peek()) {
					stack.push(arr[i]);
				}else if(k>0){
					int presentEle= arr[i];
					while(!stack.isEmpty() && presentEle> stack.peek() && k-->0) {
					stack.pop();
				}
					stack.push(presentEle);
				}
			}
			
			while(k-->0) {
				stack.pop();
			}
			Stack<Integer> finalStack=new Stack<>();
			while (!stack.isEmpty()) {
				finalStack.push(stack.pop());
			}
			
			while(!finalStack.isEmpty())
				System.out.print(finalStack.pop()+" ");
			System.out.println();
		}
	}

}
