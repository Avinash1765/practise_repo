package com.example.demo.codeforces;

import java.util.Scanner;

public class Problem327A {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		int n= s.nextInt();
		int arr[]=new int[n];
		int zeroArr[]= new int[n];
		int oneArr[]= new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]= s.nextInt();
			
			if(i==0 && arr[i]==1)
				oneArr[i]=1;
			if(i==0 && arr[i]==0)
				zeroArr[i]=1;
			
			if(i>=1) {
				if(arr[i]==1) {
					oneArr[i]= oneArr[i-1] +1;
					zeroArr[i]= zeroArr[i-1];
				}
				else {
					zeroArr[i]= zeroArr[i-1] +1;
					oneArr[i]= oneArr[i-1];
				}
			}
		}
		
		int max= Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++) {
			for(int j=i; j<n; j++) {
				int numZeros=zeroArr[j]- (i==0 ? 0 : zeroArr[i-1]);
				int numOnes=oneArr[j]- (i==0 ? 0 : oneArr[i-1]);
				
				max= Math.max(max, (numZeros-numOnes));
			}
		}
		
		System.out.println(oneArr[n-1]+max);
	}

}
