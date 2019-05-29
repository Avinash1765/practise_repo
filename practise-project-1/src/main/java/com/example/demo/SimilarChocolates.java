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

class SimilarChocolates {
    public static void main(String args[] ) throws Exception {
       
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        Map<Integer,Integer> map=new HashMap<>();
        while(n-->0){
            int num=s.nextInt();
            int count=0;
            for(int i=1;i<=Math.sqrt(num);i++){
                if(num%i==0) {
                	if(num/i==i)
                		count+=2;
                	else
                		count++;
                }
            }
            map.computeIfPresent(count, (k,v) -> v+1);
            map.computeIfAbsent(count, k -> 1);
        }
        
        int ans=0;
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
        	ans+=addToAns(entry.getValue());
        }
        
        System.out.println(ans);
        

    }

	private static int addToAns(Integer value) {
		if(value==1)
			return 0;
		else {
			return ((value-1)*(value))/2;
		}
	}
}
