package com.example.demo.codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubSeq {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = s.nextInt();

		System.out.println(longestSubsequence(n, arr));

		s.close();
	}

	private static int longestSubsequence(int size, int arr[]) {

		int lis[] = new int[size];
		lis[0]=1;
		//Arrays.fill(lis, 1);

		for (int i = 1; i < size; i++) {
			
			int maxVal= 0;

			for(int j=i-1;j>=0;j--) {
				if(arr[j] < arr[i]) {
					maxVal = Math.max(maxVal, lis[j]);
				}
			}
			
			lis[i]= maxVal +1;
		}

		return Arrays.stream(lis).max().getAsInt();
	}

}
