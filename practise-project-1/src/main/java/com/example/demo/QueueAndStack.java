package com.example.demo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class QueueAndStack {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++)
			arr[i]=s.nextInt();
		
		printData(arr);
	}

	private static void printData(int[] arr) {
		Queue<Integer> queue=new LinkedList<>();
		Stack<Integer> dummyQueue=new Stack<>();
		Stack<Integer> stack=new Stack<>();
		
		for(int i=0;i<arr.length;i++) {
			if(ifPrime(arr[i]))
				queue.add(arr[i]);
			else
				dummyQueue.add(arr[i]);
		}
		
		while(!dummyQueue.isEmpty()) {
			stack.push(dummyQueue.pop());
		}
		
		printCollection(queue);
		printCollection(stack);
	}

	private static void printCollection(Collection<Integer> collection) {
		collection.forEach(obj -> System.out.print(obj+" "));
		System.out.println();
	}

	private static boolean ifPrime(int n) {
		for(int i=2;i<n;i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}

}
