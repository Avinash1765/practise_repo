package com.example.demo;

import java.util.Scanner;

public class PicuBank {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		
		while(t-->0) {
			int d=s.nextInt();
			int a=s.nextInt();
			int m=s.nextInt();
			int b=s.nextInt();
			int x=s.nextInt();
			
			int  minDays=0;
			
			int low=0, high=10000;
			int finalAnswer=0;
			while(low<=high) {
				minDays= low + (high-low)/2;
				
				long ans=calculate(d,a,b,m,minDays);
				
				if(ans==x) {
					finalAnswer=minDays;
					break;
				}
				else if(ans > x) {
					finalAnswer=minDays;
					high=minDays-1;
				}else {
					low=minDays+1;
				}
			}
			System.out.println(finalAnswer);
		}
	}

	private static long calculate(int intialAmount, int a, int b, int mseq, int minDays) {
		
		long finalAmount=intialAmount;
		
		int coupleParts= minDays/(mseq+1);
		int reminder= minDays%(mseq+1);
		
		if(coupleParts !=0) {
			finalAmount += mseq*a*coupleParts;
			finalAmount+= b* coupleParts;
		}
		finalAmount+= a*reminder;
		
		return finalAmount;
	}

}
