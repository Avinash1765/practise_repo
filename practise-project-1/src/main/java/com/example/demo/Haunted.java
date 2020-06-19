package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import static java.util.Map.Entry;

class Ghost{
	long key;
	int val;
	
	public Ghost(long key, int value) {
		this.key= key;
		this.val= value;
	}
	
}

class BestGhostComparator implements Comparator<Ghost>{

	@Override
	public int compare(Ghost o1, Ghost o2) {
		
		if(o1.val==o2.val)
			return new Long(o2.key- o1.key).intValue();
		else
			return o2.val-o1.val;
		
	}
	
}

public class Haunted {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		int n=s.nextInt();
		long m=s.nextLong();
		
		Map<Long, Integer> map=new HashMap<>();
		Queue<Ghost> queue=new PriorityQueue<>(new BestGhostComparator());
		
		while(n-->0) {
			long ele= s.nextLong();
			map.computeIfPresent(ele, (k,v)-> v+1);
			map.computeIfAbsent(ele, k -> 1);
			
			Iterator<Ghost> itr=queue.iterator();
			Ghost targetGhost=null;
			while(itr.hasNext()) {
				Ghost ghost=itr.next();
				if(ghost.key==ele) {
					targetGhost= ghost;
					break;
				}
			}
			if(targetGhost!=null)
				queue.remove(targetGhost);
			queue.add(new Ghost(ele, map.get(ele)));
			System.out.println(queue.peek().key +" "+ queue.peek().val);
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
