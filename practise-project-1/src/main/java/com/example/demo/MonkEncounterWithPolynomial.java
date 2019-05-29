package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MonkEncounterWithPolynomial {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		
		int t=s.nextInt();
		
		while(t-->0) {
			int a=s.nextInt();
			int b=s.nextInt();
			int c=s.nextInt();
			int k=s.nextInt();
			int rightVal= k-c;
			
			long low=0, high= 100000;
			long ans=0;
			
			while(low<=high) {
				long mid= low + (high-low)/2;
				
				long val=fun(mid,a,b);
				
				if(val == rightVal) {
					ans=mid;
					break;
				}
				else if(val < rightVal)
					low= mid+1;
				else {
					ans=mid;
					high=mid-1;
				}
			}
			System.out.println(ans);
		}
	}
	
	private static long fun(long mid,int a, int b) {
		return (a*mid*mid) + (b*mid);
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
