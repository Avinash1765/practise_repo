package com.example.demo;
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes*/
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class StackMedium {
    public static void main(String args[] ) throws Exception {
    
        Scanner s = new Scanner(System.in);
     int t=s.nextInt();
     int n=s.nextInt();
        while(t-->0){
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++)
			arr[i]=s.nextInt();
		
		int ans[]=solve(arr,n);
		
		for(int i=0;i<n;i++)
			System.out.println(ans[i]);
		
        }
    }
    
    private static int[] solve(int arr[],int n){
        int ans[]=new int[n];
        
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        ans[0]=1;
        for(int i=1;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]){
                stack.pop();
            }
            
            if(stack.isEmpty())
                ans[i]= i+1;
            else
                ans[i]= i-stack.peek();
            stack.push(arr[i]);
        }
        return ans;
    }
}
