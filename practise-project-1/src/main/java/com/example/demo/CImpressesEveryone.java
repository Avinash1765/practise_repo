package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CImpressesEveryone {
	public static void main(String[] args) {
		FastReader s=new FastReader();
		
		int n=s.nextInt();
		
		long arr[]=new long[n];
		
		//String str[]=s.nextLine().split(" ");
		
		for(int i=0;i<n;i++) {
			arr[i]=s.nextLong();
		}
		long prefix[]=new long[n];
		prefix[0]=arr[0];
		
		for(int i=1;i<n;i++)
			prefix[i]=arr[i]+prefix[i-1];
		int q=s.nextInt();
		while(q-->0) {
			long num=s.nextLong();
			
			num= prefix[n-1]-num+1;
			
			int low=0, end=n-1;
			int ans=0;
			if(num>=prefix[0]) {
				
			while(low<=end) {
				int mid= low + (end-low)/2;
				
				if(prefix[mid]==num || (prefix[mid] > num && prefix[mid-1] < num )) {
					ans=mid;
					break;
				}
				else if(prefix[mid] < num)
					low=mid+1;
				else
					end=mid-1;
			}
			}
			if(ans%2==0)
				System.out.println("A");
			else
				System.out.println("B");
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
