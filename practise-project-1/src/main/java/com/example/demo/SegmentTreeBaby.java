package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node23{
	int low, high, val;
	
	public Node23(int low, int high, int val) {
		this.low=low;
		this.high=high;
		this.val=val;
	}
}

public class SegmentTreeBaby {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		int n=s.nextInt();
		int q=s.nextInt();
		
		Node23 query[]=new Node23[q];
		int tempq=q;
		while(q-->0) {
			query[q]=new Node23(s.nextInt()-1, s.nextInt()-1, s.nextInt());
		}
		int min= Integer.MAX_VALUE;
		for(int i=0;i<tempq;i++) {
			int arr[]=new int[n];
			for(int j=0;j<tempq;j++) {
				
				if(i==j)
					continue;
				else {
					arr[query[j].low]= arr[query[j].low] + (query[j].val);
					if((query[j].high)+1 < n)
						arr[(query[j].high)+1]=arr[(query[j].high)+1] + (-1 * query[j].val);
					else
						arr[(query[j].high)] = arr[(query[j].high)] + (-1 * query[j].val);
				}
			}
			int maxVal=arr[0];
			
			for(int k=1;k< n;k++) 
				arr[k]= arr[k] + arr[k-1];
			
			for(int k=1;k< n;k++) {
				if(arr[k] > maxVal)
					maxVal= arr[k];
			}
			
			if(maxVal < min)
				min= maxVal;
		}
		System.out.println(min);
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
