package com.example.demo.codeforces;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStackRecursion {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		Stack<Integer> stk= new Stack<>();
		
		for(int i=0;i<n;i++) {
			stk.push(s.nextInt());
		}
		
		Stack<Integer> dup= (Stack)stk.clone();
		
		System.out.println("BEFORE");
		while(!dup.isEmpty()) {
			System.out.print(dup.pop()+ " ");
		}
		System.out.println();
		reverse(stk);
		
		System.out.println("AFTER");
		while(!stk.isEmpty()) {
			System.out.print(stk.pop()+ " ");
		}
	}

	private static void reverse(Stack<Integer> stk) {
		if(stk.isEmpty()) {
			return;
		}
		
		int ele= stk.pop();
		
		reverse(stk);
		
		stk.push(ele);
	}

}
