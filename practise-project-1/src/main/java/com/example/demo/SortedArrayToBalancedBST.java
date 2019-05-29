package com.example.demo;

class Node{
	int data;
	Node left,right;
	
	public Node(int data) {
		super();
		this.data = data;
	}
}
public class SortedArrayToBalancedBST {

	public static void main(String[] args) {
		int arr[]= {1,2,3};
		SortedArrayToBalancedBST obj=new SortedArrayToBalancedBST();
		Node root=obj.convertToBalancedBST(arr,0, arr.length-1);
		//System.out.println(obj.findHeight(root));
		
		Node root2=new Node(1);
		root2.left=new Node(2);
		root2.left.left=new Node(3);
		
		
		
		if(obj.checkedIfBalancedBST(root2))
			System.out.println("BALANCED");
		else
			System.out.println("NOT BALANCED");
	}

	private Node convertToBalancedBST(int[] arr,int left,int right) {
		if(left>right)
			return null;
		
		int mid= (left+right)/2;
		
		Node root=new Node(arr[mid]);
		
		root.left =convertToBalancedBST(arr, left, mid-1);
		root.right=convertToBalancedBST( arr, mid+1, right);
		
		return root;
	}
	
	private int findHeight(Node root) {
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return 1;
		
		int lheight=1+ findHeight(root.left);
		int rheight=1+ findHeight(root.right);
		
		return lheight>=rheight?lheight:rheight;
	}
	
	private boolean checkedIfBalancedBST(Node root) {
		int lheight= findHeight(root.left);
		int rheight= findHeight(root.right);
		
		return Math.abs(lheight-rheight)>1?false:true;
	}

}
