package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class PermuteArray {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		int t=s.nextInt();
		
		while(t-->0) {
			int n=s.nextInt();
			int k=s.nextInt();
			HashMap<Integer, Integer> map=new HashMap<>();
			int arr[]=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=s.nextInt();
				map.computeIfPresent(arr[i], (ke,v)-> v+1);
		    	 map.computeIfAbsent(arr[i], ke -> 1);
			}
			boolean flag=true;
			for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
				if(entry.getValue()%(n/k) !=0) {
					flag=false;
				}
			}
			System.out.println("YES");
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
