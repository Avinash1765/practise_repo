package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class LittleMonkWilliamson {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		int n=s.nextInt();
		
		int max=0;
		int min= 0;
		
		TreeMap<Integer, Integer> map=new TreeMap<>();
		
		while(n-->0) {
			String opt=s.next();
			
			switch(opt) {
			case "Push":
				int ele=s.nextInt();
				
				if(ele>max) {
					if(min==0)
						min=max;
					max=ele;
				}else if(ele<max && ele>min) {
					min= ele;
				}else
					min=ele;
				map.computeIfPresent(ele, (k,v)-> v+1);
				map.computeIfAbsent(ele, k -> 1);
				break;
			case "CountHigh":
				if(map.isEmpty())
					System.out.println(-1);
				else
					System.out.println(map.getOrDefault(max, 1));
				break;
			case "CountLow":
				if(map.isEmpty())
					System.out.println(-1);
				else
					System.out.println(map.getOrDefault(min, 1));
				break;
			default:
				
				if(map.size()== 0) {
					System.out.println(-1);
				}else if(map.size()==1) {
					boolean flag=false;
					System.out.println(0);
					int maxV=map.get(max);
					if(maxV ==1) {
						map.remove(max);
						flag=true;
					}
					else
						map.put(max,  maxV-1);
					if(flag)
						max=min=0;
				}else {
					System.out.println(max- min);
					int maxVal=map.get(max);
					boolean maxFlag= false;
					boolean minFlag= false;
					
					if(maxVal ==1) {
						map.remove(max);
						maxFlag= true;
					}
					else
						map.put(max,  maxVal-1);
					
					int minVal=map.get(min);
					if(minVal ==1) {
						map.remove(min);
						minFlag= true;
					}
					else
						map.put(min, minVal-1);
					
					if(maxFlag) {
						max=map.lowerKey(max);
					}
					
					if(minFlag) {
						min=map.higherKey(min);
					}
				}
					
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
