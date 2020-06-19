package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BeautifulSegments {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		
		int t=s.nextInt();
		
		while(t-->0) {
			int n=s.nextInt();
			int arr[]=new int[n];
			
			for(int i=0;i<n;i++)
				arr[i]=s.nextInt();
			int mid=1;
			int count=0;
			for(int i=0;i<n-2;i++) {
				for(int j=i+2; j<n;j=j+2) {
					mid= (j+i)/2;
					if(j==i+2 && arr[mid]>= arr[i] && arr[mid]> arr[j]) {
						count++;
						continue;
					}
					if((arr[j-2]> arr[j-1]) && (arr[j-1]> arr[j]) && arr[mid]>= arr[mid-1]) {
						count++;
					}
				}
			}
			
			System.out.println(count);
			
			
			
			
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
