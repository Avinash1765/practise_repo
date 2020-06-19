package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class PowerUp {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		
		int n=s.nextInt();
		
		int arr[]=new int[n];
		
		for(int i=0;i< n;i++)
			arr[i]=s.nextInt();
		long maxSum=0;
		
		for(int i=0;i<n;i++) {
			long sum=0;
			Set<Integer> set=new HashSet<>();
			for(int j=i;j<n;j++) {
				if(!set.contains(arr[j])) {
					sum+= arr[j];
					set.add(arr[j]);
					if(sum>maxSum)
						maxSum=sum;
				}else {
					break;
				}
			}
			set.clear();
		}
		System.out.println(maxSum);

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
