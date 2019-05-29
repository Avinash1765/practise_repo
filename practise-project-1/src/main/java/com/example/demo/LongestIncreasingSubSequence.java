package com.example.demo;

import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubSequence {

	public static void main(String[] args) {
		
		int arr[]= {0 ,8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		
		System.out.println(LCS(arr));
	}

	private static int LCS(int[] arr) {
		int len=arr.length;
		
		int lseq[]=new int[len];
		Arrays.fill(lseq, 1);
		
		
		for(int i=1;i<len;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j] && (lseq[j]+1)>lseq[i])
					lseq[i]=lseq[j]+1;
			}
		}
		
		int max=Integer.MIN_VALUE;
		
		for(int i=0;i<len;i++)
			if(lseq[i]>max)
				max=lseq[i];
		return max;
	}

}
