package com.example.demo.codeforces;

import java.util.Scanner;

public class MaximizeCutSegmentsDP {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int x= s.nextInt();
		int y= s.nextInt();
		int z= s.nextInt();
		
		System.out.println(maximizeCuts(n, x, y, z));
		
	}
	
	public static int maximizeCuts(int n, int x, int y, int z)
    {
       int[] dp= new int[n+1];
       //dp[0]= 1;
    
       for(int i=1; i<=n;i++){
            int usingF =  ((i>=x) && (i==x || dp[i-x]!=0)) ? 1 + dp[i-x] : 0;
            int usingS =  ((i>=y) && (i==y || dp[i-y]!=0)) ? 1 + dp[i-y] : 0;
            int usingT =  ((i>=z) && (i==z || dp[i-z]!=0)) ? 1 + dp[i-z] : 0;
            
            dp[i]= Math.max(Math.max(usingF, usingS), usingT);
        }
        
        return dp[n];
    }

}
