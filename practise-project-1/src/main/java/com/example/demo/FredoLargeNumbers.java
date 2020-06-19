package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Node24{
	int firstIndex;
	BigInteger val;
	int freq;
	
	public Node24(int firstIndex, BigInteger val, int freq) {
		this.firstIndex= firstIndex;
		this.val= val;
		this.freq= freq;
	}
}

class Node24Comp implements Comparator<Node24>{

	@Override
	public int compare(Node24 o1, Node24 o2) {
		if(o1.freq == o2.freq)
			return o1.firstIndex - o2.firstIndex;
		else
			return 0;
	}
	
}

public class FredoLargeNumbers {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		int n=s.nextInt();
		
		BigInteger arr[]=new BigInteger[n];
		
		Map<BigInteger, Node24> map=new HashMap<>();
		
		for(int i=0;i< n;i++) {
			BigInteger k= new BigInteger(s.next());
			final int ind=i;
			map.computeIfPresent(k, (ke,v) -> {
				v.freq++;
				return v;
			});
			
			map.computeIfAbsent(k, (ke) -> {
				return new Node24(ind, k, 1);
			});
		}
		
		ArrayList<Node24> list=new ArrayList<>(map.values()); 
		
		int q=s.nextInt();
		
		while(q-->0) {
			int opt= s.nextInt();
			int freq= s.nextInt();
			int minFirst=Integer.MAX_VALUE;
			if(opt ==0) {
				
				list.forEach(obj -> {
					if(obj.freq >= freq && obj.firstIndex <minFirst)
						minFirst= obj.firstIndex;
				});
			}
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
