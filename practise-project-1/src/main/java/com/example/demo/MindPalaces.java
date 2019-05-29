package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node14{
	int a,b;
	
	public Node14(int a,int b) {
		this.a=a;
		this.b=b;
	}
}

public class MindPalaces {
	static int m,n;

	public static void main(String[] args) {
		FastReader s=new FastReader();
		m=s.nextInt();
		n=s.nextInt();
		
		int arr[][]=new int[m][n];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]= s.nextInt();
			}
		}
		
		int q=s.nextInt();
		
		while(q-->0) {
			int ele=s.nextInt();
			findPos(arr,ele,0,n-1);
			
			
		}
	}
	
	
	
	
	
	
	
	private static void findPos(int[][] arr, int ele, int i, int j) {
		
		while(i<m && j>=0) {
			if(arr[i][j]==ele) {
				System.out.println(i+" "+j);
				return;
			}
			if(ele>arr[i][j])
				i++;
			else
				j--;
		}
		
		System.out.println("-1 -1");
	}
	
	/*private static boolean limitcheck(int a,int b) {
		if(a>=m || b>=n)
			return false;
		return true;
	}*/







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
	
	/*if(i>=m || j>=n || ele< arr[i][j])
		return new Node14(-1,-1);
	if(ele==arr[i][j])
		return new Node14(i,j);
	if(limitcheck(i+1, j) && ele==arr[i+1][j])
		return new Node14(i+1,j);
	if(limitcheck(i, j+1) && ele==arr[i][j+1])
		return new Node14(i,j+1);
	
	
	if(limitcheck(i+1, j) && limitcheck(i, j+1) && ele > arr[i+1][j] && ele< arr[i][j+1])
		return findPos(arr, ele, i+1, j);
	if(limitcheck(i+1, j) && limitcheck(i, j+1) && ele < arr[i+1][j] && ele> arr[i][j+1])
		return findPos(arr, ele, i, j+1);
	
	Node14 obj=findPos(arr,ele,i+1,j);
	
	if(obj==null || (obj.a==-1 && obj.b==-1))
		findPos(arr,ele,i,j+1);*/


}
