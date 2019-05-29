package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node20 implements Comparable<Node20>{
	long value;
	int index;
	
	public Node20(int index, long value) {
		this.index= index;
		this.value= value;
	}

	@Override
	public int compareTo(Node20 o) {
		
		if(value != o.value)
			return new Long(o.value - value).intValue();
		else
			return index - o.index;
	}
}

public class MonkSteveSmith {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		
		int n=s.nextInt();
		int k=s.nextInt();
		
		String str= s.nextLine();
		
		String st[]=str.split("\\s+");
		
		Queue<Node20> queue=new PriorityQueue<>();
		
		for(int i=1;i<=n;i++)
			queue.add(new Node20(i, Long.parseLong(st[i-1])));
		
		while(k-->0) {
			Node20 obj= queue.poll();
			
			System.out.print(obj.index+" ");
			obj.value--;
			
			queue.add(obj);
		}
		
	}
	
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 


}
