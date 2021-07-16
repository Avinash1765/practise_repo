package com.example.geeks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinSwapsRequired {
	public static void main (String[] args) {
	    Scanner s=new Scanner(System.in);
	    int t=s.nextInt();
	    
	    while(t-->0){
	        int n=s.nextInt();
	        
	        int arr[]= new int[n];
	    int numValues=0;
	    int count=0;
	    List<Integer> list= new ArrayList<>();
	    
	    for(int i=0;i<n;i++)
	        arr[i]= s.nextInt();
	    int k=s.nextInt();
	    
	    for(int i=0;i<n;i++){
	        if(arr[i]<=k){
	            list.add(i);
	            numValues++;
	        }
	    }
	    
	    for(int i=1; i<numValues; i++ ){
	        if(list.get(i) - list.get(i-1) > 1){
	            count++;
	        }
	    }
	    
	    System.out.println(count);
	    }
	}
}
