package com.example.demo;

import java.math.BigInteger;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes*/
import java.util.Scanner;
import java.util.Stack;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class StackOperations {
    public static void main(String args[] ) throws Exception {
       
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int k=s.nextInt();
        
        BigInteger arr[]=new BigInteger[n];
        Stack<BigInteger> stack=new Stack<>();
        
        for(int i=0;i< n;i++)
            arr[i]=s.nextBigInteger();
            
        for(int i=arr.length-1;i>= 0;i--)
            stack.push(arr[i]);

        System.out.println(solve(stack,n,k));
    }

	private static BigInteger solve(Stack<BigInteger> stack, int n, int k) {
		if(n==1 && k%2==0)
			return stack.pop();
		if(n==1 && k%2==1)
			return BigInteger.valueOf(-1);
		
		
		BigInteger max=stack.pop();
		k--;
		
		while(k-->1 && !stack.isEmpty()) {
			BigInteger ele=stack.pop();
			if(ele.compareTo(max)==1)
				max=ele;
		}
		
		
		return max;
	}
    
    
}

