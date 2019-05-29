package com.example.demo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class MaximiserLeScore
 {
	static TreeMap<Integer, PriorityQueue<Long>> digitSumMap=new TreeMap<>(Collections.reverseOrder());
	public static void main(String[] args) {
		FastReader s=new FastReader();
		
		int t=s.nextInt();
		
		while(t-->0) {
				digitSumMap.clear();
				BigInteger sherlockSum=BigInteger.ZERO;
				BigInteger watsonSum=BigInteger.ZERO;
				int n=s.nextInt();
				int k=s.nextInt();
			 	long arr[]=new long[n];
			 	
			 	Queue<Long> queue=new PriorityQueue<>(Collections.reverseOrder());
			 	for(int i=0;i<n;i++) {
			 		long val= s.nextLong();
			 		
			 		queue.add(val);
			 		insertDigitSumMap(val);
			 	}
			 	
			 	String str= s.next();
			 	
			 	boolean turn = str.equals("HEADS"); //   true (Sherlock)  false (Watson)
			 	
			 	int tempK =k;
			 	while(true) {
			 		
			 		while(!queue.isEmpty() && tempK-->0) {
			 			
			 			if(turn) {
			 				long val= queue.poll();
			 				sherlockSum=sherlockSum.add(BigInteger.valueOf(val));
			 				removeInDigitSumMap(val);
			 			}else {
			 				Map.Entry<Integer, PriorityQueue<Long>> entry=digitSumMap.firstEntry();
			 				long val=entry.getValue().poll();
			 				watsonSum=watsonSum.add(BigInteger.valueOf(val));
			 				if(entry.getValue().isEmpty())
			 					digitSumMap.remove(entry.getKey());
			 					
			 					
			 				queue.remove(val);
			 			}
			 		}
			 		
			 		if(queue.isEmpty())
			 			break;
			 		
			 		tempK =k;
			 		turn = !turn;
			 		
			 	}
			 	
			 	System.out.println(sherlockSum + " "+ watsonSum);
			 	
		}
	}
	
	private static void removeInDigitSumMap(long val) {
		int sum=0;
		long temp=val;
		
		while(temp!=0) {
			sum += temp%10;
			temp/=10;
		}
		
		PriorityQueue<Long> q=digitSumMap.get(sum);
		if(q.size() ==1)
			digitSumMap.remove(sum);
		else
			q.remove(val);
	}

	private static void insertDigitSumMap(long val) {
		int sum=0;
		long temp=val;
		
		while(temp!=0) {
			sum += temp%10;
			temp/=10;
		}
		
		digitSumMap.computeIfPresent(sum, (k,v) -> {
			v.add(val);
			return v;
		});
		
		digitSumMap.computeIfAbsent(sum, (k) -> {
			PriorityQueue<Long> qu= new PriorityQueue<>(Collections.reverseOrder());
			qu.add(val);
			return qu;
		});
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
