package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Node3{
	int data;
	Node3 left, right;
	public Node3(int data) {
		super();
		this.data = data;
	}
	
	
}

public class ZigZagBST {
	static List<Integer> list;
	static Node3 parent;

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		Node3 root=null;
		
		ZigZagBST obj=new ZigZagBST();
		
		while(true) {
			System.out.println("1. insert");
			System.out.println("2. inorder tranversal");
			System.out.println("3. zigzag BST");
			System.out.println("4. delete node");
			System.out.println("4. Exit");			
			int opt=s.nextInt();
			
			switch(opt) {
			case 1:
				System.out.println("Enter data to insert");
				int data=s.nextInt();
				root=obj.insert(root, data);
				break;
			case 2:
				obj.inorder(root);
				break;
			case 3:
				obj.zigzagtree(root);
				break;
			case 4:
				System.out.println("Enter node to delete");
				int ele=s.nextInt();
				obj.deleteNode(root,ele);
				break;
			case 5:
				System.exit(0);
			}
		}
	}

	private void deleteNode(Node3 root, int ele) {
		Node3 actualElementToDelete;
		if(root.data== ele)
			actualElementToDelete= root;
		else {
			actualElementToDelete=getParentAndElementDetails(root, ele);
		}
		
		if(actualElementToDelete.left==null && actualElementToDelete.right==null) {
			if(parent.left==actualElementToDelete)
				parent.left=null;
			else
				parent.right=null;
		}
		
		if(actualElementToDelete.left!=null && actualElementToDelete.right==null) {
			if(parent.left==actualElementToDelete)
				parent.left=actualElementToDelete.left;
			else
				parent.right=null;
		}
			
	}

	private Node3 getParentAndElementDetails(Node3 root, int ele) {
		if(root.data== ele) 
			return root;
		
		
		if(ele< root.data) {
			parent= root;
			 return getParentAndElementDetails(root.left, ele);
		}else {
			parent= root;
			 return getParentAndElementDetails(root.right, ele);
		}
		
	}

	private Node3 searchForElement(Node3 root, int ele) {
		if(root.data==ele)
			return root;
		if(ele < root.data) 
			return searchForElement(root.left, ele);
		if(ele> root.data) 
			return searchForElement(root.right, ele);
		
		return null;
	}

	private void printNodesAtLevel(int level, Node3 root) {
		if(level==0 || root==null)
			return;
		
		if(level==1)
			list.add(root.data);
		
		printNodesAtLevel(level-1, root.left);
		printNodesAtLevel(level-1, root.right);
		
	}

	private void zigzagtree(Node3 root) {
		
		int height=getHeight(root);
		for(int i=1;i<=height; i++) {
			list= new ArrayList<>();
			zigzagPrinter(root, i);
			
			if(i%2==0) 
				Collections.reverse(list);
			System.out.println(list);
		}
	}

	private void zigzagPrinter(Node3 root, int level) {
		printNodesAtLevel(level, root);
	}

	private int getHeight(Node3 root) {
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return 1;
		
		int lheight= 1+ getHeight(root.left);
		int rheight= 1+ getHeight(root.right);
		
		return lheight>rheight ? lheight : rheight;
	}

	private void inorder(Node3 root) {
		if(root!=null) {
			inorder(root.left);
			System.out.print(root.data+ " ");
			inorder(root.right);
		}
	}

	private Node3 insert(Node3 root,int data) {
		Node3 temp=root;
		
		Node3 obj=new Node3(data);
		if(temp==null)
			temp=obj;
		else {
			if(data< temp.data)
				temp.left= insert(temp.left,data);
			else
				temp.right= insert(temp.right,data);
		}
		
		return temp;
	}
}
