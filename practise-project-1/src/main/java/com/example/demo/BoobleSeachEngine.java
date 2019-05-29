package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BoobleSeachEngine {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		int q=s.nextInt();
		Map<Character, HashMap<String, Integer>> map=new HashMap<>();
		
		while(q-->0) {
			int opt=s.nextInt();
			
			switch(opt){
			case 1:
				String str= s.next();
				map.computeIfPresent(str.charAt(0), (k,v) -> {
					if(v == null) {
						v= new HashMap<>();
						v.put(str, 1);
					}else {
						v.computeIfPresent(str, (ke,va) -> va+1);
						v.computeIfAbsent(str, (ke) -> 1);
					}
					return v;
				});
				
				map.computeIfAbsent(str.charAt(0), (k) ->{
					HashMap<String, Integer> tmap=new HashMap<>();
					tmap.put(str, 1);
					return tmap;
				});
				break;
			case 2:
				char ch =s.next().charAt(0);
				HashMap<String, Integer> tmap=map.get(ch);
				
				TreeSet<Map.Entry<String, Integer>> finalMap = new TreeSet<>(new Comparator<Map.Entry<String, Integer>>() {

					@Override
					public int compare(Entry<String, Integer> arg0, Entry<String, Integer> arg1) {
						int val=arg1.getValue() - arg0.getValue();
						
						if(val !=0)
							return val;
						else
							return arg0.getKey().compareTo(arg1.getKey());
						
					}
					
				});
				
				if(tmap!= null)
					finalMap.addAll(tmap.entrySet());
				else {
					System.out.println("null null null");
					continue;
				}
				
				StringBuilder finalString = new StringBuilder();
				int k=3;
				
				Iterator<Map.Entry<String, Integer>> itr=finalMap.iterator();
				while(k-->0 && itr.hasNext()) {
					finalString.append(itr.next().getKey()+" ");
				}
				
				while(k-->0) {
					finalString.append(null + " ");
				}
				
				System.out.println(finalString);
				
				
				
				
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
