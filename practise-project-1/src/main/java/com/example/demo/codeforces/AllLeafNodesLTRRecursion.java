package com.example.demo.codeforces;

import java.util.Scanner;

public class AllLeafNodesLTRRecursion {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		int n= s.nextInt();
		
		TreeNode<Integer> root= null;
		
		for(int i=0;i<n;i++) {
			if(i==0)
				root= new TreeNode(i+1);
			else {
				root.addNode(i+1);
			}
		}
		
		//root.printInOrder();
		
		printLeaves(root);
		
	}

	private static void printLeaves(TreeNode<Integer> root) {
		if(root== null)
			return;
		if(root.getLeft()== null && root.getRight()==null) {
			System.out.print(root.getEle()+ " ");
			return;
		}
		
		printLeaves(root.getLeft());
		printLeaves(root.getRight());
	}

}
