package com.example.demo;


import java.util.Scanner;
import java.util.*;
class LRU
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			Set<Integer> s = new HashSet<Integer>() ;
				int n = sc.nextInt();
				LRUCache g = new LRUCache(n);
			int q = sc.nextInt();
			
			while(q>0)
			{
			
				String c = sc.next();
			//	System.out.println(c);
				if(c.equals("GET"))
				{
					int x = sc.nextInt();
					System.out.print(g.get(x)+" ");
				}
				if(c.equals("SET"))
				{
					int x = sc.nextInt();
					int y  = sc.nextInt();
					g.set(x,y);
				}
			
			q--;
			//System.out.println();
			}
		t--;
		System.out.println();
		}
	}
}


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*You are required to complete below class */
class Node{
    int key;
    int value;
    Node next;
    public Node(int key,int value){
        this.key=key;
        this.value=value;
    }
}
/*class LRUCache {
   
   private int maxSize;
   private int currentListSize=0;
   private Node root;
    Inititalize an LRU cache with size N 
    public LRUCache(int N) {
        root=null;
        maxSize=N;
    }
    
    Returns the value of the key x if 
     present else returns -1 
    public int get(int x) {
        Node temp=root;
        
        while(temp!=null){
            if(temp.key==x)
                break;
            temp=temp.next;
        }
        
        if(temp==null)
            return -1;
        else{
            root.next=temp.next;
            root=temp;
            return temp.value;
        }
    }
    
    
    private void addNode(Node obj){
        Node prev=null;
        if(root==null){
            
            root=obj;
            currentListSize++;
            return;
        }
        Node temp=root;
        while(temp!=null){
            if(temp.key==obj.key)
                break;
            prev=temp;
            temp=temp.next;
        }
        
        if(temp==null){
            sizeExceedCheck();
            obj.next=root;
            root=obj;
            currentListSize++;
        }
        else{
            int v=root.value;
            sizeExceedCheck();
            prev.next=temp.next;
            temp.next=root;
            root=temp;
            root.value+=v;
            currentListSize++;
        }
    }
    
    private void sizeExceedCheck(){
        Node temp=root;
        int count=1;
        Node prev=null;
        while(temp.next!=null){
            count++;
            prev=temp;
            temp=temp.next;
        }
        if(count>=maxSize)
            prev.next=null;
    }
    
    
    Sets the key x with value y in the LRU cache 
    public void set(int x, int y) {
            addNode(new Node(x,y));
    }
}
*/
