package com.example.demo;

public class LinkedListReverse {
	
	private int data;
	private LinkedListReverse next=null;
	
	
	public LinkedListReverse(int data) {
		super();
		this.data = data;
	}

	public static LinkedListReverse addNode(LinkedListReverse head, int data) {
		LinkedListReverse temp=head;
		if(head==null) {
			head=new LinkedListReverse(data);
			return head;
		}
		while(head.next!=null)
			head=head.next;
		
		head.next= new LinkedListReverse(data);
		return temp;
	}

	public static void main(String[] args) {
		LinkedListReverse head= null;
		head=addNode(head, 10);
		head=addNode(head, 20);
		head=addNode(head, 30);
		head=addNode(head, 40);
		
		printList(head);
		head=reverseList(head);
		printList(head);
	}

	private static LinkedListReverse reverseList(LinkedListReverse head) {
		LinkedListReverse prev=null,current=head,next;
		
		while(current!=null) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		
		return prev;
	}

	private static void printList(LinkedListReverse head) {
		LinkedListReverse temp=head;
		
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
}
