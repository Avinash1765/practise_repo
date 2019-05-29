package com.example.demo;


	import java.util.ArrayList;
// INITIAL CODE
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
	// A Binary Tree node
	class Node
	{
	    int data;
	    Node left, right;
	    Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	}
	class Boundary_Traversal
	{
		int height(Node node)
			{
				if(node==null)
					return 0;
				int l = 1+height(node.left);
				int r = 1+height(node.right);
				if(l>r)
					return l;
				else
					return r;
			}
		
	    // driver function to test the above functions
	    public static void main(String args[])
	    {
			
	        // Input the number of test cases you want to run
	        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();
			//Node root=null;
	        while (t > 0)
	        {
	            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
	            int n = sc.nextInt();
	            Node root=null;
	            while (n > 0)
	            {
	                int n1 = sc.nextInt();
	                int n2 = sc.nextInt();
	                char lr = sc.next().charAt(0);
	                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
	                Node parent = m.get(n1);
	                if (parent == null)
	                {
	                    parent = new Node(n1);
	                    m.put(n1, parent);
	                    if (root == null)
	                        root = parent;
	                }
	                Node child = new Node(n2);
	                if (lr == 'L')
	                    parent.left = child;
	                else
	                    parent.right = child;
	                m.put(n2, child);
	                n--;
	            }
			
	            GfG g = new GfG();
	            g.printBoundary(root);
				System.out.println();
	            t--;
				
	        }
	    }
	}

	/*Please note that it's Function problem i.e.
	you need to write your solution in the form of Function(s) only.
	Driver Code to call/invoke your function is mentioned above.*/

	/* A Binary Tree node
	class Node
	{
	    int data;
	    Node left, right;
	    Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	}*/
	class GfG
	{
		void printBoundary(Node node)
		{
			Node temp=node;
			ArrayList<Node> leftMembers=new ArrayList<>();
			
			while(temp!= null) {
				leftMembers.add(temp);
				if(temp.left!=null || temp==node)
					temp=temp.left;
				else
					temp=temp.right;
			}
			
			temp= node;
			temp= temp.right;
			
			Stack<Node> rightMembers=new Stack<>();
			
			while(temp != null) {
				rightMembers.push(temp);
				if(temp.right!=null)
					temp=temp.right;
				else
					temp=temp.left;
			}
			
			ArrayList<Node> leafNodes=new ArrayList<>();
			
			getLeafNodes(node, leafNodes);
			
			Node firstLeftLeaf=leafNodes.get(0);
			if(firstLeftLeaf == leftMembers.get(leftMembers.size()-1))
				leafNodes.remove(0);
			
			if(!leafNodes.isEmpty()) {
				Node rightMostLeaf= leafNodes.get(leafNodes.size()-1);
				
				if(!rightMembers.isEmpty()) {
				Node rightMostNode=rightMembers.peek();
				if(rightMostNode == rightMostLeaf)
					leafNodes.remove(leafNodes.size()-1);
				}
			}
			
			for(Node leftEle : leftMembers)
				System.out.print(leftEle.data+" ");
			
			for(Node leaf : leafNodes)
				System.out.print(leaf.data+" ");
			
			while(!rightMembers.isEmpty())
				System.out.print(rightMembers.pop().data+" ");
		}

		private void getLeafNodes(Node node, ArrayList<Node> leafNodes) {
			if(node ==null)
				return;
			if(node.left == null && node.right==null) {
				leafNodes.add(node);
				return;
			}
			
			getLeafNodes(node.left, leafNodes);
			getLeafNodes(node.right, leafNodes);
		}
	}
