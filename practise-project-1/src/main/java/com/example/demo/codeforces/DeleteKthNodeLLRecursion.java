package com.example.demo.codeforces;

import java.util.Scanner;

public class DeleteKthNodeLLRecursion {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		Node parent= null;

		for (int i = 0; i < n; i++) {
			if(i==0)
				parent= new Node(s.nextInt());
			else
				parent.addNode(s.nextInt());
		}

		int k = s.nextInt();

		System.out.println("BEFORE");
		parent.printList();

		deletekthNode(parent, null, k);

		System.out.println("AFTER");
		parent.printList();

	}

	private static void deletekthNode(Node parent, Node prev, int k) {
		if (k == 1) {
			prev.setNext(parent.getNext());
			return;
		}

		deletekthNode(parent.getNext(), parent, k - 1);

	}

	/*
	 * private static void printList(Node parent) { Node temp = parent;
	 * 
	 * while (temp != null) { System.out.print(temp.getEle() + " "); temp =
	 * temp.getNext(); } System.out.println(); }
	 */

	/*
	 * private static Node addNode(Node parent, int ele) { Node newNode= new
	 * Node(ele);
	 * 
	 * if(parent==null) { parent= newNode; } else { Node temp = parent;
	 * 
	 * while(temp.getNext()!= null) { temp= temp.getNext(); } temp.setNext(newNode);
	 * }
	 * 
	 * return parent; }
	 */

}
