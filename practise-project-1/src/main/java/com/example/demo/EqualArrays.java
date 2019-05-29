package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EqualArrays {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		int t=s.nextInt();
		while(t-->0) {
			int n=s.nextInt();
			
			int arr[]=new int[n];
			
			long lpre[]=new long[n];
			long rsuf[]=new long[n];
			
			arr[0]=s.nextInt();
			lpre[0]= arr[0];
			
			for(int i=1;i<n;i++) {
				arr[i]=s.nextInt();
				lpre[i]= lpre[i-1]+ arr[i];
			}
			
			rsuf[n-1]=arr[n-1];
			
			for(int i=n-2;i>=0;i--)
				rsuf[i]= arr[i]+rsuf[i+1];
			
			int equiInd=0;
			long lval=0, rval=0;
			
			long minVal= Long.MAX_VALUE;
			
			while(lval <= rval && equiInd <(n-1)) {
				
				lval= lpre[equiInd];
				rval= rsuf[equiInd+1];
				
				if(rval-lval <0)
					break;
				
				if((rval-lval) < minVal) {
					minVal= rval- lval;
				}
				
				equiInd++;
			}
			
			if(minVal== Long.MAX_VALUE)
				System.out.println(-1);
			else
				System.out.println(minVal);
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
