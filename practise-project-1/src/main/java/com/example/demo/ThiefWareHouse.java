package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ThiefWareHouse {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		int t=s.nextInt();
		
		while(t-->0) {
			int n=s.nextInt();
			long arr[]=new long[n];
			
			for(int i=0;i<n;i++)
				arr[i]=s.nextInt();
			
			Stack<Integer> stack=new Stack<>();
			long maxArea=0;
			int i=0;
			for(;i<n;) {
				if(stack.isEmpty()) {
					stack.push(i++);
				}else {
					if(arr[i]>= arr[stack.peek()]) {
						stack.push(i++);
					}else {
						while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
							long area= arr[stack.pop()] * (stack.empty() ? i : i - stack.peek() - 1);
							if(area > maxArea)
								maxArea= area;
						}
					}
				}
					
			}
			
			while(!stack.isEmpty()) {
				long area= arr[stack.pop()] * (stack.empty() ? i : i - stack.peek() - 1);
				if(area > maxArea)
					maxArea= area;
			}
			System.out.println(maxArea);
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
