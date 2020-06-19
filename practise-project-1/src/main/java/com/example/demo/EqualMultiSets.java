package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EqualMultiSets {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		
		int n=s.nextInt();
		BigInteger a[]=new BigInteger[n];
		BigInteger b[]=new BigInteger[n];
		
		String arr[]=s.nextLine().split(" ");
		String brr[]=s.nextLine().split(" ");
		for(int i=0;i<n;i++)
			a[i]=new BigInteger(arr[i]);
		
		for(int i=0;i<n;i++)
			b[i]=new BigInteger(brr[i]);
		
		Arrays.sort(a);
		Arrays.sort(b);
		long ans=0;
		
		final long CON= 10000000007l;
		
		for(int i=0;i<n;i++) {
			long safe=(a[i].subtract(b[i])).mod(BigInteger.valueOf(CON)).longValue();
			ans=(ans+safe)%CON;
		}
		
		System.out.println(ans);
		
		
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
