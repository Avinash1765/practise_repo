package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Intrusction{
	int from,to;
	
	public Intrusction(int from, int to) {
		this.from= from;
		this.to=to;
	}
}

public class BuggyBot {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		
		int n=s.nextInt();
		int m=s.nextInt();
		int k=s.nextInt();
		
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		
		for(int i=0;i<n;i++)
			list.add(new ArrayList<>());
		
		while(m-->0) {
			int source=s.nextInt();
			int dest=s.nextInt();
			
			list.get(source-1).add(dest-1);
		}
		
		TreeSet<Integer> set=new TreeSet<>();
		
		List<Intrusction> instList=new ArrayList<>();
		
		while(k-->0) {
			instList.add(new Intrusction(s.nextInt(), s.nextInt()));
		}
		
		for(int i=0;i<=n;i++) {
			int startPos= 0;
			
			
			
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
