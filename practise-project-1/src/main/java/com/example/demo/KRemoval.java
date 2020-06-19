package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Node29{
	int sum, index;
	
	public Node29(int sum, int index) {
		this.sum= sum;
		this.index= index;
	}
}

public class KRemoval {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		int n=s.nextInt();
		int k=s.nextInt();
		
		LinkedList<Integer> list=new LinkedList<>();
		
		for(int i=0;i<n;i++)
			list.add(s.nextInt());
		
		TreeSet<Node29> set=new TreeSet<>(new Comparator<Node29>() {

			@Override
			public int compare(Node29 o1, Node29 o2) {
				return o2.sum-o1.sum;
			}
		});
		
		for(int i=1;i<=n-2;i++) {
			set.add(new Node29(Math.abs(list.get(i-1)-list.get(i+1)), i));
		}
		
		set.clear();
		while(k-->0) {
			Node29 obj=set.pollFirst();
			list.remove(obj.index);
		}
		
		int size= list.size();
		long sum=0;
		
		for(int i=0;i<size-1;i++) {
			sum+= Math.abs(list.get(i)-list.get(i+1));
		}
		
		System.out.println(sum);
		
		
		
		
		
		
		
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
