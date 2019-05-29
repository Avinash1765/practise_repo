package com.example.demo;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes*/
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class AmanLab {
    public static void main(String args[] ) throws Exception {
      
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        Queue<Node9> queue=new PriorityQueue<>(new NodeComparator());
        
        for(int i=1;i<=n;i++){
        	int start= s.nextInt();
        	int time= s.nextInt();
            queue.add(new Node9(start,start+time,i));
        }
        
        
        
        while(!queue.isEmpty()) {
        	System.out.print(queue.poll().pos+" ");
        }

    }
}

class Node9{
    int start;
    int end;
    int pos;
    
    public Node9(int start,int end,int pos){
        this.start=start;
        this.end=end;
        this.pos=pos;
    }
}

class NodeComparator implements Comparator<Node9>{

	@Override
	public int compare(Node9 obj1, Node9 obj2) {
		return obj1.end- obj2.end;
	}
}

