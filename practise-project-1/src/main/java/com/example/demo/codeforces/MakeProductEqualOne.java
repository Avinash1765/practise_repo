package com.example.demo.codeforces;

import java.util.Scanner;

public class MakeProductEqualOne {

	public static void main(String[] args) {
		Scanner  s=new Scanner(System.in);
		
		long nCnt=0;
		long ans=0;
		long zeroCnt=0;
		int n= s.nextInt();
		
		long arr[]= new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i]= s.nextLong();
			if(arr[i]<0) 
				nCnt++;
			if(arr[i]==0)
				zeroCnt++;
			ans += Math.abs((Math.abs(arr[i]) - 1));
		}
		
		if((nCnt&1)==1 && zeroCnt==0)
			ans+=2;
		System.out.println(ans);
			
	}

}
