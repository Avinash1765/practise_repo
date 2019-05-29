/*package whatever //do not write package name here */
package com.example.demo;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class GFG {
	public static void main (String[] args) {
		
		
		Scanner s=new Scanner(System.in);
		
		int tests=s.nextInt();
		Integer t=new Integer(tests);
		Integer.toBinaryString(t).toCharArray().
		
		while(tests>0){
		    Map<Integer,Integer> map=new HashMap<>();
		    int num=s.nextInt();
		    for(int i=0;i<num;i++){
		        int n=s.nextInt();
		        if(map.get(n)==null)
		            map.put(n,1);
		        else
		        	map.put(n,map.get(n)+1);
		    }
		    int m=s.nextInt();
		    sort1MapPrint(map,m);
		}
	}

	private static void sort1MapPrint(Map<Integer, Integer> map,int m) {
		List<Entry<Integer,Integer>> list=new LinkedList<>(map.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				
				return o1.getValue()-o2.getValue();
			}
			
		});
		
		Iterator<Entry<Integer,Integer>> itr=list.iterator();
		
		while(itr.hasNext() && m>0) {
			Entry<Integer,Integer> item=itr.next();
			if(item.getValue()<=m) {
				itr.remove();
				m-=item.getValue();
			}
			else {
				System.out.println(list.size());
				return;
			}
		}
		System.out.println(list.size());
	}
}