package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QueryMultiples {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		
		int n=s.nextInt();
		int q=s.nextInt();
		
		int arr[]=new int[n];
		
		String str[]=s.nextLine().split(" ");
		for(int i=0;i<n;i++)
			arr[i]=Integer.parseInt(str[i]);
		
		while(q-->0) {
			int index=s.nextInt();
			int num=s.nextInt();
			
			int mul[]=new int[n];
			int count=0;
			for(int i=0;i<n;i++) {
				if(arr[i]%num ==0)
					count++;
			}
			
			mul[0]=count;
			
			for(int i=1;i<n;i++) {
				if(arr[i-1]%num ==0) {
					mul[i]= mul[i-1]-1;
				}else {
					mul[i]=mul[i-1];
				}
			}
			System.out.println(mul[index-1]);
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
