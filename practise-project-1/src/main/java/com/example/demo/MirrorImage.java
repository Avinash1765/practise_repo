package com.example.demo;

import java.util.Scanner;
import java.util.Stack;

class Node22{
	int data;
	
	Node22 left,right;
	
	public Node22(int val) {
		data=val;
	}
}

public class MirrorImage {
	static Stack<Character> stack=new Stack<>();
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int q=s.nextInt();
		
		Node22 root=new Node22(1);
		
		
		while(n-->1) {
			int parent=s.nextInt();
			int val= s.nextInt();
			char direction= s.next().charAt(0);
			
			root=insert(root, parent, val, direction);
		}
		
		levelorder(root);
		
		while(q-->0) {
			int ele=s.nextInt();
			
			getPath(root, ele, 'S');
			Stack<Character> pathStack= new Stack<>();
			while(!stack.isEmpty())
				pathStack.push(stack.pop());
			System.out.println(getMirrorImage(root, pathStack));
		}
	}

	private static void levelorder(Node22 root) {
		
		int height= getHeight(root);
		
		for(int i=1; i<=height;i++) {
			printLevel(root, i);
			System.out.println();
		}
		
	}

	private static void printLevel(Node22 root, int i) {
		if(root == null)
			return;
		if(i==1) {
			System.out.print(root.data+" ");
			return;
		}
		
		printLevel(root.right, i-1);
		printLevel(root.left, i-1);
			
	}

	private static int getHeight(Node22 root) {
		if(root == null)
			return 0;
		
		if(root.left == null && root.right== null)
			return 1;
		
		int lhieght= 1+getHeight(root.left);
		int rheight= 1+getHeight(root.right);
		
		return lhieght > rheight ? lhieght : rheight;
	}

	private static int getMirrorImage(Node22 root, Stack<Character> pathStack) {
		if(root== null || (pathStack.isEmpty() && root == null))
			return -1;
		
		if(pathStack.isEmpty())
			return root.data;
		
		Character ch=pathStack.pop();
		
		if(ch == 'R')
			return getMirrorImage(root.left, pathStack);
		else
			return getMirrorImage(root.right, pathStack);
		
	}

	private static boolean getPath(Node22 temp, int ele, char ch) {
		
		if( temp== null) {
			return false;
		}
		
		if(ch!= 'S')
			stack.push(ch);
		
		if(temp.data == ele)
			return true;
		
		if(getPath(temp.left, ele, 'L') || getPath(temp.right, ele, 'R'))
			return true;
		
		stack.pop();
		return false;
	}


	private static Node22 insert(Node22 root, int parent, int val, char direction) {
		Node22 temp= root;
		
		Node22 ob=findParent(temp, parent);
		
		if(direction=='L')
			ob.left= new Node22(val);
		else
			ob.right= new Node22(val);
		
		return temp;
		
	}
	
	private static Node22 findParent(Node22 temp, int parent) {
		if( temp== null)
			return null;
		
		if(temp.data == parent)
			return temp;
		
		Node22 obj= findParent(temp.left, parent);
		if(obj==null) {
			return findParent(temp.right, parent);
		}else
			return obj;
		
	}

}
