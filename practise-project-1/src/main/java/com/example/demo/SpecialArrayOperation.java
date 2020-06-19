package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class SpecialArrayOperation {
	
	public static void main(String[] args) {
		FastReader s=new FastReader();
		Map<Long, Integer> minMap=new TreeMap<>();
		TreeMap<Long, Integer> maxMap=new TreeMap<>(new Comparator<Long>() {

			@Override
			public int compare(Long o1, Long o2) {
				return new Long(o2-o1).intValue();
			}});
		
		 int n=s.nextInt();
	     int q=s.nextInt();
	     long arr[]=new long[n];
	     for(int i=0;i<n;i++) 
	    	 arr[i]=s.nextInt();
	     
	     
	     while(q-->0) {
	    	 int ke=s.nextInt();
	    	 minMap.clear();
	    	 maxMap.clear();
	    	 for(int i=0;i< n;i++) {
		    	 minMap.computeIfPresent(arr[i], (k,v)-> v+1);
		    	 minMap.computeIfAbsent(arr[i], k -> 1);
		    	 
		    	 maxMap.lcomputeIfPresent(arr[i], (k,v)-> v+1);
		    	 maxMap.computeIfAbsent(arr[i], k -> 1);
	    	 }
	    	
	    	 while(ke-->0) {
	    		 Map.Entry<Long, Integer> minEntry=minMap.entrySet().iterator().next();
	    		 Map.Entry<Long, Integer> maxEntry=maxMap.entrySet().iterator().next();
	    		 
	    		 long diff= maxEntry.getKey()-minEntry.getKey();
	    		 
	    		 if(minEntry.getValue()>1)
	    			 minMap.put(minEntry.getKey(), minEntry.getValue()-1);
	    		 else
	    			 minMap.remove(minEntry.getKey());
	    		 
	    		 if(maxEntry.getValue()>1)
	    			 maxMap.put(maxEntry.getKey(), maxEntry.getValue()-1);
	    		 else
	    			 maxMap.remove(maxEntry.getKey());
	    		 
	    		 if(minMap.get(maxEntry.getKey())>1)
	    			 minMap.put(maxEntry.getKey(), minMap.get(maxEntry.getKey())-1);
	    		 else
	    			 minMap.remove(maxEntry.getKey());
	    		 
	    		 if(maxMap.get(minEntry.getKey())>1)
	    			 maxMap.put(minEntry.getKey(), maxMap.get(minEntry.getKey())-1);
	    		 else
	    			 maxMap.remove(minEntry.getKey());
	    		 
	    		 
	    		 minMap.compute(diff, (k,v)-> (v==null) ? 1: v+1);
	    		 maxMap.compute(diff, (k,v)-> (v==null) ? 1: v+1);
	    		 
	    	 }
	    	 
	    	 int sum=0;
    		 for(Map.Entry<Long, Integer> entry:maxMap.entrySet()) {
    			 sum+= entry.getKey() * entry.getValue();
    		 }
    		 
    		 System.out.println(sum);
	    	 
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int q=s.nextInt();
        
        Queue<Long> minHeap=new PriorityQueue<>();
        Queue<Long> maxHeap=new PriorityQueue<>(new Comparator<Long>() {

			@Override
			public int compare(Long o1, Long o2) {
				return new Long(o2-o1).intValue();
			}

					});
        long arr[]=new long[n];
        for(int i=0;i<n;i++) {
        	arr[i]=s.nextInt();
        }
        
        while(q-->0) {
        	minHeap.clear();
        	maxHeap.clear();
        	int k=s.nextInt();
        	
        	for(int i=0;i<n;i++) {
        		minHeap.add(arr[i]);
            	maxHeap.add(arr[i]);
            }
        	
        	
        	
        	while(k-->0) {
        		long max= maxHeap.poll();
        		long min= minHeap.poll();
        		
        		if(!maxHeap.isEmpty()) {
        			maxHeap.remove(min);
        			minHeap.remove(max);
        		}
        		
        		long diff= max-min;
        		maxHeap.add(diff);
        		minHeap.add(diff);
        		
        	}
        	int sum=0;
        	while(!maxHeap.isEmpty())
        		sum+= maxHeap.poll();
        	
        	System.out.println(sum);
        }
	}*/

}
