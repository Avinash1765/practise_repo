package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SquareTrans {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		int n=s.nextInt();
		int arr[]= new int[n];
		arr[0]=s.nextInt();
		
		for(int i=1;i<n;i++) {
			int ele=s.nextInt();
			arr[i]=ele+ arr[i-1];
		}
		
		int q=s.nextInt();
		
		while(q-->0) {
			int target=s.nextInt();
			
			if(target < arr[0])
				System.out.println(1);
			else {
			int iund=binarySearch(arr, target);
			iund= iund!=-1 ? iund+1 : -1;
			System.out.println(iund);
			}
		}
	}
	
	private static int binarySearch(int[] arr, int target) {
		
		int low=0, high= arr.length-1;
		
		while(low<=high && high>=0) {
			int mid= low + (high-low)/2;
			
			if(arr[mid]== target || (arr[mid]> target && arr[mid-1]<target))
				return mid;
			else if(arr[mid] < target) {
				low= mid+1;
			}else {
				high=mid-1;
			}
		}
		return -1;
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
