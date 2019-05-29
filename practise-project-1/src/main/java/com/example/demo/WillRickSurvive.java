package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WillRickSurvive {

	public static void main(String[] args) {
		FastReader s=new FastReader();
        int t=s.nextInt();
        while(t-->0) {
        	int n=s.nextInt();
        	int arr[]=new int[n];
        	for(int i=0;i<n;i++)
        		arr[i]=s.nextInt();
        	
        	int count=0;
        	
        	Arrays.sort(arr);
        	int start=0;
        	int bullets=0;
        	while(start<n && arr[start]>0) {
        		if(bullets/6!=0 && bullets%6==0) {
        			for(int i=start;i<n;i++)
            			arr[i]--;
        			bullets=0;
        		}else {
        			bullets++;
        			count++;
            		start++;
            		for(int i=start;i<n;i++)
            			arr[i]--;
        		}
        	}
        	if(start==n)
        		System.out.println("Rick now go and save Carl and Judas");
        	else {
        		System.out.println("Goodbye Rick");
        		System.out.println(count);
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
