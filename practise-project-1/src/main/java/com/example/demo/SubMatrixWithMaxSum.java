package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubMatrixWithMaxSum {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		int t=s.nextInt();
		
		while(t-->0) {
		int row=s.nextInt();
		int col=s.nextInt();
		
		int arr[][]=new int[row][col];
		
		for(int i=0;i<row;i++) {
			for(int j=0;j< col;j++) {
				arr[i][j]= s.nextInt();
			}
		}
		maxSum(arr,row, col);
		}
	}
	
	private static void maxSum(int[][] arr, int row, int col) {
		
		int maxGlobalSum=0;
		int maxLeft=0, maxRight=0, maxTop=0, maxBottom=0;
		
		for(int i=0; i<col;i++) {
			
			int sub1D[]=new int[row];
			
			for(int j=i;j<col;j++) {
				
				for(int k=0; k<row;k++)
					sub1D[k]+= arr[k][j];
				
				
				int currentMax=0;
				if(currentMax > maxGlobalSum)
					maxGlobalSum= currentMax;
				maxTop= 0;
				maxBottom= 0;
				for(int ind=0;ind< row;ind++) {
					currentMax += sub1D[ind];
					
					if(currentMax <0) {
						currentMax=0;
						//maxTop= i+1;
					}else
						maxBottom=i;
					if(currentMax > maxGlobalSum) {
						maxGlobalSum = currentMax;
						//maxLeft= j;
						//maxRight= i;
					}
				}
				
				
				
			}
		}
		
		System.out.println(maxGlobalSum);
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
