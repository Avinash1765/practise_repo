package com.example.demo;

import java.util.Arrays;
import java.util.Scanner;

public class KJump {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int k=s.nextInt();
		int n=s.nextInt();
		
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++)
			arr[i]=s.nextInt();
		
		int lis[]=new int[n];
		
		Arrays.fill(lis, 1);
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]-arr[j]>=k && lis[j] +1 > lis[i]) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		System.out.println(lis[n-1]);
	}

}
