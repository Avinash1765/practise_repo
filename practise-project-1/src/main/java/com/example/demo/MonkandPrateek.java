package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class MonkandPrateek {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        int t=n;
        int collsionCount=0;
        Map<Integer,Integer> map=new TreeMap<>(Collections.reverseOrder());
        while(t-->0) {
        	int num=s.nextInt();
        	int temp=num;
        	int sum=0;
        	while(temp!=0) {
        		sum+= (temp%10);
        		temp/=10;
        	}
        	
        	int hashIs= num^sum;
        	
        	map.computeIfPresent(hashIs, (k,v) -> v+1);
        	
        	map.computeIfAbsent(hashIs, (k) -> 1);
        }
        	collsionCount= n- map.size();
        	int r3gz3nFunVal=0;
        	if(collsionCount==0)
        		r3gz3nFunVal=map.entrySet().iterator().next().getKey();
        	else {
        		List<Map.Entry<Integer, Integer>> entryList=new ArrayList<>(map.entrySet());
        		
        		Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer> >() { 
                    public int compare(Map.Entry<Integer, Integer> o1,  
                                       Map.Entry<Integer, Integer> o2) 
                    { 
                        return (o2.getValue()).compareTo(o1.getValue()); 
                    } 
                });
        		
        		Map.Entry<Integer, Integer> maxEntry= entryList.get(0);
        		
        		for(int i=1;i<entryList.size();i++) {
        			if(entryList.get(i).getValue()!= maxEntry.getValue())
        				break;
        			maxEntry= entryList.get(i);
        		}
        		r3gz3nFunVal=maxEntry.getKey();
        	}
        	
        	System.out.println(r3gz3nFunVal+" "+ collsionCount);
        	
        	/*if(map.get(new Node12(hashIs))==null)
        		map.put(new Node12(hashIs),1);
        	else {
        		collsionCount++;
        		Node12 obj=map.;	
        	}*/
        
       /* if(collsionCount==0) {
        	System.out.println(new TreeSet<>(map.keySet()).pollLast());
        	System.out.println(0);
        }else {
        	
        }*/
	
	}
}
