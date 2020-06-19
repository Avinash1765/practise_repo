package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LittleMonkandVirat {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		
		int n=s.nextInt();
		
		long t20[]=new long[n];
		long odi[]=new long[n];
		long test[]=new long[n];
		long arr[]=new long[n];
		long e=149940833;
		for(int i=0;i<n;i++)
			t20[i]=s.nextLong();
		
		for(int i=0;i<n;i++)
			odi[i]=s.nextLong();
		
		for(int i=0;i<n;i++)
			test[i]=s.nextLong();
		
		for(int i=0;i<n;i++)
			arr[i]=odi[i] + t20[i] + test[i];
		
		Arrays.sort(arr);
		
		int q=s.nextInt();
		
		while(q-->0) {
			int k=s.nextInt();
			if(k>=n)
				System.out.println(-1);
			else {
			System.out.println(arr[k-1]);
			int j=k+1;
			while(j<n) {
				arr[j-1]=arr[j];
				j++;
			}
			
			n--;
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
