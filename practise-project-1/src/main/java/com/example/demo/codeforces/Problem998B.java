package com.example.demo.codeforces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem998B {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		int n= s.nextInt();
		int b= s.nextInt();
		
		int arr[]=new int[n];
		
		int evenArr[]= new int[n];
		int oddArr[]= new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]= s.nextInt();
			
			if(i==0) {
				if(arr[i]%2==0)
					evenArr[0]=1;
				else
					oddArr[0]=1;
			}
			
			evenArr[i]= evenArr[i-1];
			oddArr[i]= oddArr[i-1];
			
			
			if(arr[i]%2==0)
				evenArr[i]+=1;
			else
				oddArr[i]+=1;
		}
		
		List<Integer> cutCosts= new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			if(evenArr[i] == oddArr[i] && i<(n-1)) {
				if(cutCosts.size()==0)
					cutCosts.add(Math.abs(arr[i]- arr[i+1]));
				else {
					cutCosts.add(e)
				}
			}
		}
		
		Collections.sort(cutPossibleIndices);
		
		
		
	}

}
