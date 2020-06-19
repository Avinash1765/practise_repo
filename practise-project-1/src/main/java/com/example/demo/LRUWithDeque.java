package com.example.demo;


import java.util.*;
class LRUWithDeque
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
class LRUCache {
   private Map<Integer, Node> map;
   private Deque<Node> deque;
   private int maxSize;
    public LRUCache(int N) {
        map=new HashMap<Integer, Node>();
        deque=new LinkedList<>();
        maxSize= N;
    }
    
    /*Returns the value of the key x if 
     present else returns -1 */
    public int get(int x) {
    	if(map.containsKey(x)) {
    		Node obj= map.get(x);
    		deque.remove(obj);
    		deque.addFirst(obj);
    		return obj.value;
    	}
    	return -1;
    }
    
    
    private void addNode(Node obj){
        if(map.containsKey(obj.key)) {
        	Node actualElement= map.remove(obj.key);
        	deque.remove(actualElement);
        	obj.value+=actualElement.value;
        }else {
        	if(map.size()>=maxSize) {
        		Node removedNode=deque.removeLast();
        		map.remove(removedNode.key);
        		
        	}
        }
        map.put(obj.key, obj);
		deque.addFirst(obj);
    }
    
    
    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
            addNode(new Node(x,y));
    }
}

