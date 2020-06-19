package com.example.demo;

import java.util.Scanner;

//class Node{
//	int data;
//	Node next;
//	
//	public Node(int data) {
//		this.data=data;
//	}
//}

public class StackUsingLL {
	

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Node top=null;
		
		while(true) {
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Display");
			System.out.println("4. Exit");
			
			int opt=s.nextInt();
			
			switch(opt) {
			case 1:
				int ele=s.nextInt();
				top=push(top,ele);
				break;
			case 2:
				top=pop(top);
				break;
			case 3:
				break;
			case 4:
				System.exit(0);
			}
		}
	}

	private static Node pop(Node top) {
		
		
		
		return null;
	}

	private static Node push(Node top,int ele) {
		if(top==null)
			top=new Node(ele);
		else {
			Node temp=top;
			while(temp.next!=null)
				temp=temp.next;
			
			temp.next=new Node(ele);
		}
		
		return top;
	}

}
