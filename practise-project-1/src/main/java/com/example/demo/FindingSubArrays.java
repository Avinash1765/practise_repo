package com.example.demo;

import java.util.Scanner;

public class FindingSubArrays {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int arr[]=new int[n];
		int totalSum=0;
		for(int i=0;i<n;i++) {
			arr[i]=s.nextInt();
			totalSum+= arr[i];
		}
		int count=0;
		
		for(int i=0;i<n;i++) {
			int subArraySum=0;
			for(int j=i;j<n;j++) {
				
				subArraySum+= arr[j];
				if((n-(j-i+1)) == 0)
					System.out.println((i+1) + " "+ (j+1));
				else if((float)subArraySum/(j-i+1) > (float)(totalSum-subArraySum)/(n-(j-i+1))) {
					System.out.println((i+1) + " "+ (j+1));
					count++;
				}
				
			}
		}
		
	}

}
