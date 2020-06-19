package com.example.demo;

import java.util.Scanner;

public class MatrixChainMultiplication {

	public static void main(String[] args) {
		MatrixChainMultiplication obj=new MatrixChainMultiplication();
		
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		
		while(t>0) {
			int size=s.nextInt();
			int arr[]=new int[size];
			
			for(int i=0;i<size;i++)
				arr[i]=s.nextInt();
			
			System.out.println(obj.minCalculations(arr));
			
			t--;
		}
	}

	private int minCalculations(int[] p) {
		int n=p.length;
		int arr[][]=new int[n-1][n-1];
		
		for(int i=0;i< n-1;i++)
			arr[i][i]=0;
		
		
		for(int L=2;L<n;L++) {
			for(int i=1; i< n-L+1;i++) {
				int j=i+L-1;
			}
		}
		
		
		return 0;
	}

}
