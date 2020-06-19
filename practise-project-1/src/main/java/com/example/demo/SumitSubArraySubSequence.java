package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumitSubArraySubSequence {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		int t=s.nextInt();
		
		while(t-->0) {
			int n=s.nextInt();
			int arr[]=new int[n];
			
			String str[]=s.nextLine().split(" ");
			
			for(int i=0;i<n;i++)
				arr[i]=Integer.parseInt(str[i]);
			
			long maxSum=0;
			long currSum=0;
			
			int maxEle =Integer.MIN_VALUE;
			
			long maxSeqSum=0L;
			
			for(int i=0;i<n;i++) {
				if(maxEle < arr[i]) {
					maxEle= arr[i];
				}
				
				if(arr[i] >0) {
					maxSeqSum += arr[i];
				}
				
				currSum += arr[i];
				
				if(currSum < 0)
					currSum=0;
				else {
					if(currSum > maxSum)
						maxSum= currSum;
				}
			}
			
			if(maxSeqSum==0) {
				maxSeqSum= maxEle;
			}
			
			if(maxSum==0) {
				maxSum= maxEle;
			}
			
			System.out.println(maxSum+" "+ maxSeqSum);
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
