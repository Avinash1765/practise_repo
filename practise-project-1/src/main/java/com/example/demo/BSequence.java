package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.function.Consumer;

public class BSequence {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		
		int n=s.nextInt();
		
		int arr[]=new int[n];
		TreeSet<Integer> increasingSet=new TreeSet<>();
		Set<Integer> decreasingSet=new HashSet<>();
		int i=0;
		for(;i<n;i++) {
			int ele=s.nextInt();
			if(i==0) {
				increasingSet.add(ele);
				arr[i]=ele;
			}
			else {
				if(ele < arr[i-1]) {
					decreasingSet.add(ele);
					arr[i]=ele;
					break;
				}else {
					increasingSet.add(ele);
					arr[i]=ele;
				}
			}
		}
		i++;
		while(i<n) {
			decreasingSet.add(s.nextInt());
			i++;
		}
		
		int q=s.nextInt();
		
		while(q-->0) {
			int ele=s.nextInt();
			
			if(ele == increasingSet.last() || (increasingSet.contains(ele) && decreasingSet.contains(ele))) {
			}else {
				if(increasingSet.contains(ele) && !decreasingSet.contains(ele)) {
					decreasingSet.add(ele);
			}else {
				increasingSet.add(ele);
			}
			}
			System.out.println(increasingSet.size()+decreasingSet.size());
		}
		
		Consumer<Integer> printer= obj -> System.out.print(obj+" ");
		
		increasingSet.stream().forEach(printer);
		decreasingSet.stream().sorted(Collections.reverseOrder()).forEach(printer);
		
	}
	
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 

}
