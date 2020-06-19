package com.example.demo;

/*package whatever //do not write package name here */
import java.util.Arrays;
import java.util.Scanner;

class CheckIfPairSumsToParticularValue {
	public static void main (String[] args) {
		CheckIfPairSumsToParticularValue obj=new CheckIfPairSumsToParticularValue();
	    Scanner s=new Scanner(System.in);
	    int testCases=s.nextInt();
	    
	    while(testCases>0){
	        int size=s.nextInt();
	        int ele=s.nextInt();
	        int arr[]=new int[size];
	        
	        for(int i=0;i<size;i++){
	            arr[i]=s.nextInt();
	        }
	        System.out.println(obj.findResult(arr,ele));
	        testCases--;
	    }
	}
	
	private String findResult(int arr[], int ele){
	    int l=0;
	    int r=arr.length-1;
	    Arrays.sort(arr);
	    while(l<r){
	    	if((arr[l]+arr[r])==ele)
	            return "Yes";
	        if((arr[l]+arr[r])<ele)
	            l++;
	        if((arr[l]+arr[r])>ele)
	            r--;
	        
	    }
	    return "No";
	}
}

