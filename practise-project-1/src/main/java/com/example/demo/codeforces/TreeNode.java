package com.example.demo.codeforces;

import java.util.Scanner;

public class TreeNode<T> {
	private T ele;

	private TreeNode left, right;

	public T getEle() {
		return ele;
	}

	public void setEle(T ele) {
		this.ele = ele;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public TreeNode(T ele) {
		this.ele= ele;
	}
	
	public void addNode(T ele) {
		addNodeUtil(this, ele);
	}
	
	private void addNodeUtil(TreeNode root,T ele) {
		if(root==null)
			return;
		
		Scanner  s=new Scanner(System.in);
		String dir= s.next();
		
		/*
		 * if(root.left== null && root.right== null) { if(dir.equals("l")) { id(root.)
		 * root.left= new TreeNode(ele); }else { root.right= new TreeNode(ele); }
		 * return; }
		 */
		
		if(dir.equals("l")) {
			if(root.left== null) {
				root.left= new TreeNode(ele);
				return;
			}
			addNodeUtil(root.left, ele);
		}else {
			if(root.right== null) {
				root.right= new TreeNode(ele);
				return;
			}
			addNodeUtil(root.right, ele);
		}
		
		//s.close();
	}
	
	public void printInOrder() {
		printInOrderTreeUtil(this);
	}
	
	private void printInOrderTreeUtil(TreeNode root) {
		
		if(root== null)
			return;
		
		printInOrderTreeUtil(root.left);
		System.out.print(root.ele+ " ");
		printInOrderTreeUtil(root.right);
	}
	

}
