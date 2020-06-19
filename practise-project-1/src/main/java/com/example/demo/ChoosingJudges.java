package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import com.example.demo.SumitSubArraySubSequence.FastReader;

public class ChoosingJudges {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		int t=s.nextInt();
		int ind=0;
		while(t-->0) {
			int n=s.nextInt();
			int arr[]=new int[n];
			
			String str[]=s.nextLine().split(" ");
			
			for(int i=0;i<n;i++)
				arr[i]=Integer.parseInt(str[i]);
			
			long dp[]=new long[n];
			
			dp[0]=arr[0];
			
			if(n>1)
				dp[1]=arr[0] > arr[1] ? arr[0] : arr[1];
				
			for(int i=2;i<n;i++) {
				dp[i]= Math.max(dp[i-1], arr[i]+ dp[i-2]);
			}
			
			System.out.println("Case "+(++ind)+": "+dp[n-1]);
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
