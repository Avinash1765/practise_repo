package com.example.demo;

import java.util.Scanner;

public class HighestRating {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int hash[]=new int[1000001];
		
		int m=s.nextInt();
		int q=s.nextInt();
		int n=s.nextInt();
		
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++) {
			int ele=s.nextInt();
			hash[ele]++;
			arr[i]=ele;
		}
		
		
		int maxCount=0;
		for(int i=0;i<n;i++) {
			int ele=arr[i];
			int ele2=ele;
			int count=0;
			for(int j=0; j<=q;j++) {
				if(j>0) {
				ele+=m;
				ele2-=m;
				}
				
				if(ele<=1000000 && hash[ele]>0)
					count+= hash[ele];
				
				if(ele!=ele2 && ele2>0 && hash[ele2]>0)
					count+= hash[ele2];
				
			}
			if(count>maxCount)
				maxCount=count;
		
		}
		System.out.println(maxCount);
	}

}

/*for(int j=0;j<n;j++) {
if(j==i)
	continue;
if(arr[j]>=low && arr[j]<=end && (Math.abs(arr[j]-arr[i])%m)==0)
	count++;
}

if(count>maxCount)
maxCount=count;
}
*/
