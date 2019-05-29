package com.example.demo;

import java.util.Arrays;
import java.util.Scanner;

public class ClosestNumberInArrayUsingBinarySearch {

	public static void main(String[] args) {
		int finalHeightDiff=0;
		Scanner s=new Scanner(System.in);
		int boys=s.nextInt();
		int girls=s.nextInt();
		
		int boy[]=new int[boys];
		int girl[]=new int[girls];
		
		for(int i=0;i<boys;i++)
			boy[i]=s.nextInt();
		
		for(int i=0;i<girls;i++)
			girl[i]=s.nextInt();
		
		ClosestNumberInArrayUsingBinarySearch obj=new ClosestNumberInArrayUsingBinarySearch();
		Arrays.sort(girl);
		
		for(int boyHeight: boy) {
		int ind=obj.findElementClosest(boyHeight, girl,0,girl.length-1);
		finalHeightDiff+= Math.abs(boyHeight-girl[ind]);
		
		girl=removeElementFromArray(girl,ind);

		
		}
		System.out.println(finalHeightDiff);

	}

	private static int[] removeElementFromArray(int[] girl, int ind) {
		for(int i=ind+1;i<girl.length;i++)
			girl[i-1]=girl[i];
		
		int newGirlArray[]=Arrays.copyOf(girl, girl.length-1);
		return newGirlArray;
	}

	private int findElementClosest(int ele, int[] arr,int l,int r) {
		if(l<=r) {
			int mid=l+ (r-l)/2;
			
			if(arr[mid]==ele || mid==r || mid==l)
				return mid;
			
			if(arr[mid]<ele && ele<arr[mid+1])
				return (ele-arr[mid])<=(arr[mid+1]-ele)?mid:mid+1;
			
			if(arr[mid]>ele && arr[mid-1]<ele)
				return (arr[mid]-ele)>=(ele-arr[mid-1])?mid-1:mid;
				
			if(ele<arr[mid])
				return findElementClosest(ele, arr, l, mid-1);
			
			return findElementClosest(ele, arr, mid+1, r);
		}
		
		
		
		return -1;
	}

}
