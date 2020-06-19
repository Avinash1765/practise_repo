package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

class FuelPoint implements Comparable<FuelPoint>{
	int distanceFromHome, petrolAvailabe;
	
	public FuelPoint(int distanceFrom, int petrol) {
		distanceFromHome=distanceFrom;
		petrolAvailabe= petrol;
	}

	@Override
	public int compareTo(FuelPoint obj) {
		int val1= distanceFromHome - petrolAvailabe;
		int val2= obj.distanceFromHome - obj.petrolAvailabe;
		
		if(val1 != val2)
			return val1-val2;
		else
			return distanceFromHome - obj.distanceFromHome;
	}
	
	@Override
	public boolean equals(Object obj) {
		return distanceFromHome == ((FuelPoint)obj).distanceFromHome;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(distanceFromHome);
	}
	
	
}

public class GuptaEscape {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		int t=s.nextInt();
		while(t-->0) {
			int count=0;
			int stops=s.nextInt();
			
			int distance= s.nextInt();
			int petrolInTank= s.nextInt();
			TreeMap<Integer, Integer> map=new TreeMap<>(Collections.reverseOrder());
			TreeSet<Integer> set=new TreeSet<>(Collections.reverseOrder());
			while(stops-->0) {
				int dist=s.nextInt();
				int petro= s.nextInt();
				map.put(dist, petro);
				
				set.add(dist);
			}
			
			while((distance - petrolInTank)>0 && !map.isEmpty()) {
				int temp=distance -petrolInTank;
				
				int lowerBoundKey=map.ceilingKey(temp);
				int highestKey=map.keySet().iterator().next();
					
				Map<Integer, Integer> entriesToRemove=map.subMap(highestKey, lowerBoundKey);
				
				
				
				
				if(entry==null) {
					break;
				}else {
					count++;
					petrolInTank = petrolInTank + entry.getValue() - (distance-entry.getKey().distanceFromHome);
					distance= entry.getKey().distanceFromHome;
					
					
					while(set.ceiling(distance) != null) {
						map.remove(new FuelPoint(set.ceiling(distance), 0));
					}
					
					
				}
				
			}
			
			System.out.println(count);
			
			
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
