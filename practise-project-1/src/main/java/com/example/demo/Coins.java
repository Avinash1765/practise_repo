package com.example.demo;

import java.util.Arrays;
import java.util.Scanner;

public class Coins {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		
		long arr[]=new long[n];
		
		//String str[]=s.nextLine().split(" ");
		
		for(int i=0;i<n;i++)
			arr[i]=s.nextLong();
		
		Arrays.sort(arr);
		
		int low=0, high=n-1;
		long lsum=0, rsum=0;
		boolean ans=true;
		
		if(n>1) {
		lsum=arr[0];
		rsum=arr[n-1];
		low++;
		high--;
		while(low<=high) {
			if(lsum == rsum)
				break;
			else if(lsum < rsum) {
				lsum+= arr[low++];
			}else {
				rsum+= arr[high--];
			}
		}
		
		if(lsum==rsum) {
			long startEle=arr[low];
			for(int i=low+1;i<=high;i++) {
				if(arr[i] != startEle) {
					ans= false;
					break;
				}
			}
		}else {
			ans=false;
		}
		
		}else {
			ans=false;
		}
		
		if(ans)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
