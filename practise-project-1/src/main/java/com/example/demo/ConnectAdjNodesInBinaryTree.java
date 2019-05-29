package com.example.demo;


import java.util.HashMap;
import java.util.LinkedList;
//import java.lang.Math;
import java.util.Queue;
import java.util.Scanner;
// A Binary Tree node
class Node32
{
    int data;
    Node32 left, right, nextRight;
    Node32(int item)
    {
        data = item;
        left = right = nextRight = null;
		
    }
}
class BT_Connect_Adjacent_Node
{
void inorder(Node32 node)
	{
		if(node==null)
			return ;
		else
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		
	}
	void printSpecial(Node32 root)
	{
		if(root == null)
			return ;
		Node32 node = root;
		while(node != null)
		{
			System.out.print(node.data+" ");
			node = node.nextRight;
		}
		if(root.left != null)
			printSpecial(root.left);
		else 
			printSpecial(root.right);
		
	}
	
	
	
	// driver function to test the above functions
    public static void main(String args[])
    {
		
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
		BT_Connect_Adjacent_Node  can = new BT_Connect_Adjacent_Node ();
		//Node32 root=null;
		
        while (t > 0)
        {
            HashMap<Integer, Node32> m = new HashMap<Integer, Node32> ();
            int n = sc.nextInt();
            Node32 root=null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node32 parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node32(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node32 child = new Node32(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }
		
            ConnectAdjNodesInBinaryTree g = new ConnectAdjNodesInBinaryTree();
			
			g.connect(root);
			can.printSpecial(root);
			System.out.println();
			can.inorder(root);
			System.out.println();
         t--;
			
        }
    }
}



/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

// A Binary Tree node
/* class Node32
{
    int data;
    Node32 left, right, nextRight;
    Node32(int item)
    {
        data = item;
        left = right = nextRight = null;
		
    }
} */
class ConnectAdjNodesInBinaryTree
{
    void connect(Node32 root)
    {
        Queue<NodeWrapper> queue=new LinkedList<>();
        int level=0;
       // int levelCounter=0;
        queue.add(new NodeWrapper(root, 0));
        int prevLevel=-1;
        
        Node32 prevNode=null;
        
        while(!queue.isEmpty()){
            NodeWrapper obj=queue.remove();
            
            if(obj.level == prevLevel){
                prevNode.nextRight= obj.node;
            }else{
                prevLevel= obj.level;
                prevNode = obj.node;
            }
            
            if(obj.node.left != null)
                queue.add(new NodeWrapper(obj.node.left, obj.level + 1));
            
            if(obj.node.right != null)
                queue.add(new NodeWrapper(obj.node.right, obj.level + 1));
        }
    }
    
    private static class NodeWrapper{
        private Node32 node;
        private int level;
        
        public NodeWrapper(Node32 node, int level){
            this.node= node;
            this.level= level;
        }
    }
}
