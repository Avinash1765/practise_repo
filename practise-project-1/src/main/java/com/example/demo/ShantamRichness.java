package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ShantamRichness {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		int t=s.nextInt();
		
		while(t-->0) {
			int n=s.nextInt();
			int m=s.nextInt();
			int l=s.nextInt();
			int r=s.nextInt();
			int c=s.nextInt();
			int p=s.nextInt();
			int q=s.nextInt();
			int st=s.nextInt();
			int nL,nR,nC;
			int arr[]=new int[n];
			
			for(int i=l-1;i<r;i++)
				arr[i]=c;
			while(m-->1) {
				nL = (l * p + r) % n + 1;
				nR = (r * q + l) % n + 1;
				if(nL > nR) {
					int temp=nL;
					nL=nR;
					nR=temp;
				}
				nC = (c * st) % 1000000 + 1;
				l=nL;r=nR;c=nC;
				for(int i=l-1;i<r;i++)
					arr[i]=c;
			}
			int pos=0,max=Integer.MIN_VALUE;
			for(int i=0;i<n;i++) {
				if(arr[i]>max) {
					pos=i;
					max=arr[i];
				}
			}
			System.out.println((pos+1)+" "+max);
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
