package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MonkAndMultiplication {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		int n=s.nextInt();
		long arr[]=new long[n];
		
		for(int i=0;i< n;i++)
			arr[i]=s.nextLong();
		
		System.out.println("-1");System.out.println("-1");
		
		long third=0, second=0, first=0;
		
		first=Math.max(arr[0], arr[1]);
		second= Math.min(arr[0], arr[1]);
		
		for(int i=2;i<n;i++) {
			if(arr[i]>= first) {
				third=second;
				second= first;
				first=arr[i];
			}
			else if(arr[i]<first && arr[i]>= second) {
				third= second;
				second= arr[i];
			}
			else if(arr[i]<second && arr[i]> third) {
				third=arr[i];
			}
			long v=first* second * third;
			System.out.println(v);
			
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
