package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class MonkAndSomeQueries {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		TreeMap<Integer, Integer> map=new TreeMap<>();
		
		int q=s.nextInt();
		
		while(q-->0) {
			int opt=s.nextInt();
			switch(opt) {
			case 1:
				int ele=s.nextInt();
				map.compute(ele, (k,v)-> (v==null) ? 1 : v+1);
				break;
			case 2:
				int el=s.nextInt();
				if(map.get(el)==null)
					System.out.println("-1");
				else
					map.computeIfPresent(el, (k,v)-> v-1);
				break;
			case 3:
				System.out.println(map.lastEntry().getKey());
				break;
			default:
				System.out.println(map.firstEntry().getKey());
			}
		}
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
