package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Node25{
	int parent;
	
	List<Node25> childList=new ArrayList<>();
	
	public Node25(int parent, int child) {
		this.parent= parent;
		childList.add(new Node25(child));
	}

	public Node25(int child) {
		this.parent= child;
	}
}

class DeepNodePOJO{
	int data, height;
	
	public DeepNodePOJO(int data) {
		this.data= data;
	}
	
}

public class LargeCycleInTree {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		Node25 root= new Node25(s.nextInt(), s.nextInt());
		while(n-->2) {
			int parent= s.nextInt();
			int child= s.nextInt();
			
			root=addNode(root, parent, child);
		}
		
		//System.out.println(root);
		
		findMaxHeightDiffForChilds(root);
		
		
	}
	
	private static void findMaxHeightDiffForChilds(Node25 root) {
		//List<DeepNodePOJO> deepNodeList=new ArrayList<>();
		for(Node25 child: root.childList) {
			findDeepestChild(child);
		}
		
		/*Collections.sort(deepNodeList, new Comparator<DeepNodePOJO>() {

			@Override
			public int compare(DeepNodePOJO o1, DeepNodePOJO o2) {
				return o2.height - o1.height;
			}
		});*/
		
		
		//System.out.println(deepNodeList.get(0).data +" "+ deepNodeList.get(1).data);
	}

	private static DeepNodePOJO findDeepestChild(Node25 root) {
		int height=getHeight(root);
		
		DeepNodePOJO obj=getDeepNode(root, height);
		
		obj.height= height;
		
		
		return obj;
	}

	private static DeepNodePOJO getDeepNode(Node25 root, int height) {
		if(height ==1)
			return new DeepNodePOJO(root.parent);
		
		/*for(Node25 child: root.childList) {
			DeepNodePOJO obj=getDeepNode(child, height-1);
			if(obj!= null & root.childList.isEmpty())
				return obj;
		}*/
		
		if(root== null)
			return null;
		else if(height > 1) {
			for(int )
		}
		
		
		return null;
	}

	private static int getHeight(Node25 root) {
		
		if(root==null)
			return 0;
		
		if(root.childList.isEmpty())
			return 1;
		int max=Integer.MIN_VALUE;
		
		for(Node25 childNode: root.childList) {
			int val=1+getHeight(childNode);
			if(val >max)
				max=val;
		}
		
		return max;
	}

	private static Node25 findParent(Node25 root, int parent) {
		
		if(root==null)
			return null;
		
		if(root.parent== parent)
			return root;
		else {
			for(Node25 subParentNode : root.childList) {
				Node25 targetNode=findParent(subParentNode, parent);
				
				if(targetNode!=null && targetNode.parent== parent )
					return targetNode;
			}
		}
		
		return null;
	}

	private static Node25 addNode(Node25 root, int parent, int child) {
		
		Node25 targetNode=findParent(root, parent);
		
		targetNode.childList.add(new Node25(child));
		
		/*if(currentParent.parent != parent) {
			if(currentParent.childList.isEmpty())
				return null;
			for(Node25 obj : currentParent.childList) {
				addNode(obj, parent, child);
			}
		}
		currentParent.childList.add(new Node25(child));*/
		
		return root;
	}

	

}
