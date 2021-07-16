package com.example.demo.codeforces;

import java.util.Scanner;

public class YetAnotherPalindromeProblme {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		while (t-- > 0) {
			int n = s.nextInt();
			int arr[]=new int[n];
			
			for(int i=0;i<n;i++)
				arr[i]= s.nextInt();
			
			boolean breakFlag= false;
			
			for(int i=0;i<n-2;i++) {
				for(int j=i+2; j<n;j++) {
					if(arr[i] == arr[j]) {
						System.out.println("YES");
						breakFlag= true;
						break;
					}
				}
				if(breakFlag)
					break;
			}
			
			if(!breakFlag)
				System.out.println("NO");
		}
	}
}
