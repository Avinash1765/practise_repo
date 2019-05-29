package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GauravSubArray {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		int n=s.nextInt();
		int q=s.nextInt();
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++) {
			int ele= s.nextInt();
			int setBits=0;
			while(ele>0) {
				if(ele%2==1)
					setBits++;
				ele/=2;
			}
			arr[i]=setBits;
		}
		
		
		while(q-->0) {
			int k=s.nextInt();
			System.out.println(minLenSubArrWithKSum(arr, k));
		}
		
	}

	private static int minLenSubArrWithKSum(int[] arr, int k) {
		int start=0, end= 0, n=arr.length;
		
		int minLen= arr.length;
		int currSum=0;
		
		while(end<n) {
			
			while(currSum <k && end < n) {
				currSum+= arr[end++];
			}
			
			while(currSum>=k && start <n) {
				if(end-start < minLen)
					minLen= end-start;
				currSum -= arr[start++];
			}
			
		}
		return minLen;
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
