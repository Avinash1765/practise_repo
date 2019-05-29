/*package whatever //do not write package name here */
package com.example.demo;
import java.util.Scanner;

class NQueen {
	public static void main (String[] args) {
	    Scanner s=new Scanner(System.in);
	    int t=s.nextInt();
	    while(t>0){
	        int size= s.nextInt();
	        sol=new int[size][size];
	        printAnswer(size);
	        t--;
	    }
	    s.close();
	}
	
	private static void printAnswer(int n){
	    int arr[][]=new int[n][n];
	    
	    if(printAnswerUtil(arr,0))
	        System.out.println();
	    else
	        System.out.println("-1");
	}
	
	private static boolean printAnswerUtil(int arr[][],int col){
        int n=arr.length;
        
        if(col>=n)
        	return true;
        for(int i=0;i<n;i++){
            int pos=findSafe(arr,i,col);
            if(pos!=-1) {
            	arr[i][col]=1;
            	if(printAnswerUtil(arr, col+1))
            		addToSolutions(arr);
            	arr[i][col]=0;
            }
        }
        
        return false;
	    
	}

	private static void addToSolutions(int[][] arr) {
		
	}

	private static int findSafe(int[][] arr, int x, int y) {
		int n=arr.length;
		int i,j;
		for(i=0;i<n;i++) {
			if(arr[i][y]==1)
				return -1;
		}
		
		for(i=0;i<n;i++) {
			if(arr[x][i]==1)
				return -1;
		}
		
		for (i=x, j=y; i>=0 && j>=0; i--, j--) 
            if (arr[i][j] == 1) 
                return -1; 
  
        for (i=x, j=y; j>=0 && i<n; i++, j--) 
            if (arr[i][j] == 1) 
                return -1;
		
		
		return 0;
	}
}