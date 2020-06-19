package com.example.demo;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class LittleMonkandGobletofFire {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		LinkedHashMap<Integer, Queue<Integer>> linkedHashMap=new LinkedHashMap<>();
		int numOps= s.nextInt();
		while(numOps-->0) {
			String op=s.next();
			if(op.equals("E")) {
				int queNum=s.nextInt();
				int val= s.nextInt();
				
				if(linkedHashMap.get(queNum)==null)
					linkedHashMap.put(queNum, new LinkedList<Integer>());
				linkedHashMap.get(queNum).add(val);
			}else {
				Map.Entry<Integer, Queue<Integer>> entry=linkedHashMap.entrySet().iterator().next();
				System.out.println(entry.getKey()+" "+entry.getValue().poll());
				if(entry.getValue().size()==0)
					linkedHashMap.remove(entry.getKey());
			}
		}
		
	}

}
