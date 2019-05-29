package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class AmazingRace {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		
		int t=s.nextInt();
		
		while(t-->0) {
			int n=s.nextInt();
			int arr[]=new int[n];
			
			for(int i=0;i<n;i++)
				arr[i]=s.nextInt();
			
			int inFront[]=new int[n];
			int back[]=new int[n];
			
			Stack<Integer> stack=new Stack<>();
			
			for(int i=0;i<n;i++) {
				if(stack.isEmpty() || arr[i] < arr[stack.peek()])
					stack.push(i);
				else {
					while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
						int key= stack.pop();
						inFront[key]=i-key;
					}
					stack.push(i);
				}
			}
			
			while(!stack.isEmpty()) {
				int key= stack.pop();
				inFront[key]=n-1-key;
			}
			
			Stack<Integer> stack1=new Stack<>();
			
			for(int i=n-1;i>=0;i--) {
				if(stack1.isEmpty() || arr[i] < arr[stack1.peek()])
					stack1.push(i);
				else {
					while(!stack1.isEmpty() && arr[stack1.peek()] <= arr[i]) {
						int key= stack1.pop();
						back[key]= key-i;
					}
					stack1.push(i);
				}
			}
			
			while(!stack1.isEmpty()) {
				int key= stack1.pop();
				back[key]=key;
			}
			
			int sight[]=new int[n];
			int maxInd=0;
			int maxVal= Integer.MIN_VALUE;
			
			for(int i=0;i<n;i++) {
				sight[i]= (inFront[i] + back[i]) * i+1;
				if(sight[i] > maxVal) {
					maxInd= i;
					maxVal= sight[i];
				}
			}
			
			System.out.println(maxInd+1);
			
			
			
			
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
