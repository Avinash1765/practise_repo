package com.example.demo;

import java.util.Scanner;

class Node4{
	int data;
	Node4 left,right;
	public Node4(int data) {
		super();
		this.data = data;
	}
}

public class ConstructTreeFromInOrderPreOrder {
	static int preIndex=0;

	public static void main(String[] args) {
		ConstructTreeFromInOrderPreOrder obj=new ConstructTreeFromInOrderPreOrder();
		Scanner s=new Scanner(System.in);
		int testCases=s.nextInt();
		int size=s.nextInt();
		
		int inorder[]=new int[size];
		int preorder[]=new int[size];
		
		for(int i=0;i< size;i++) {
			inorder[i]= s.nextInt();
		}
		
		for(int i=0;i< size;i++) {
			preorder[i]= s.nextInt();
		}
		
		while(testCases>0) {
		Node4 root=obj.buildTree(inorder,preorder,0,size-1,size);
		
		obj.postOrderTraversal(root);
		System.out.println();
		testCases--;
		}
	}

	private void postOrderTraversal(Node4 root) {
		if(root!=null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.data+ " ");
		}
	}

	private Node4 buildTree(int[] inorder, int[] preorder,int start, int end, int size) {
		if(start<0 || end>=size || end<0 || start>=size)
			return null;
		
		if(preIndex>=size)
			return null;
		
		int rootEle= preorder[preIndex++];
		int rootIndex=-1;
		for(int i=start;i<=end;i++) {
			if(rootEle== inorder[i]) {
				rootIndex=i;
				break;
			}
		}
		
		Node4 root=new Node4(rootEle);
		
		if(start==end)
			return root;
		
		root.left= buildTree(inorder, preorder, start, rootIndex-1, size);
		root.right= buildTree(inorder, preorder, rootIndex+1, end, size);
		
		return root;
	}

}
