package com.example.demo.codeforces;

import java.util.Scanner;

public class RevSingleLLRecursion {
	
	static Node finalParent= null;

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int n= s.nextInt();
		Node parent= null;
		
		for(int i=0;i<n;i++) {
			if(i==0)
				parent= new Node(s.nextInt());
			else
				parent.addNode(s.nextInt());
		}
		
		System.out.println("BEFORE");
		parent.printList();
		
		reverseList(parent, null);
		
		System.out.println("AFTER");
		finalParent.printList();
	}

	private static void reverseList(Node current, Node prev) {
		if(current.getNext()== null) {
			finalParent= current;
			current.setNext(prev);
			return;
		}
		
		reverseList(current.getNext(), current);
		
		current.setNext(prev);
	}

}
