package com.example.demo;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes*/
import java.util.*;

class Nissan {
    public static void main(String args[] ) throws Exception {
    
        Scanner s = new Scanner(System.in);
       int n=s.nextInt();
       int k=s.nextInt();
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++)
			arr[i]=s.nextInt();
		
		int result=arr[0];
		
		int l=1,r=arr.length-1;
		k--;
		while(k>0){
		    if(arr[l]>arr[r])
		        result+=arr[l++];
		    else
		        result+=arr[r--];
		    k--;
		}
		
        System.out.println(result);
    }
}

