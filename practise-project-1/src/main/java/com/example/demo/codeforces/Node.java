package com.example.demo.codeforces;

public class Node {
	private int ele;
	private Node next;

	public Node(int ele) {
		this.ele = ele;
		this.next = null;
	}

	public int getEle() {
		return ele;
	}

	public void setEle(int ele) {
		this.ele = ele;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	/*
	 * public Node addNode(Node parent, int ele) { Node newNode= new Node(ele);
	 * 
	 * if(parent==null) { parent= newNode; } else { Node temp = parent;
	 * 
	 * while(temp.getNext()!= null) { temp= temp.getNext(); } temp.setNext(newNode);
	 * }
	 * 
	 * return parent; }
	 */

	public void addNode(int ele) {
		Node newNode = new Node(ele);
		Node parent = this;
		Node temp = parent;

		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(newNode);
	}
	
	public void printList() {
		Node temp = this;

		while (temp != null) {
			System.out.print(temp.getEle() + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}

}
