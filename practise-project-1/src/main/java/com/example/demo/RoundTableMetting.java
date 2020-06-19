package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class RoundTableMetting {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		
		int n=s.nextInt();
		int q=s.nextInt();
		
		String str[]=s.nextLine().split(" ");
		HashMap<Integer, HashSet<Integer>> map=new HashMap<>();
		for(int i=0;i<n;i++) {
			int ele=Integer.parseInt(str[i]);
			final int item=i;
			map.computeIfPresent(ele, (k,v)-> {v.add(new Integer(item)); return v;});
			map.computeIfAbsent(ele, (k) -> {
				HashSet<Integer> set=new HashSet<>();
				set.add(item);
				return set;
			});
		}
		
		
		while(q-->0) {
			int first=s.nextInt();
			int second= s.nextInt();
			List<Integer> secondList= map.get(second).stream().collect(Collectors.toList());
			List<Integer> firstList= map.get(first).stream().collect(Collectors.toList());
			
			int closestDist= Integer.MAX_VALUE;
			
			int firstSize=firstList.size();
			int secondSize= secondList.size();
			
			for(int i=0;i< firstSize;i++) {
				for(int j=0;j<secondSize;j++) {
					int dist=findDist(firstList.get(i), secondList.get(j), n);
					
					if(dist < closestDist)
						closestDist=dist;
				}
			}
			System.out.println(closestDist);
		}
		
	}
	
	private static int findDist(int first, int second, int n) {
		//int min=Integer.MAX_VALUE;
		
		int min=Math.abs(first-second);
		
		if(min==1)
			return 0;
		else
			min/=2;
		
		int big= first>second ? first : second;
		int small= first<second ? first : second;
		
		int val=((n-big)+ small)/2;
		
		if(val<min)
			min=val;
		
		return min;
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
