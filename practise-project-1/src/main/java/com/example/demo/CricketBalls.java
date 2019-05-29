/*Daksh has 'N' boxes of cricket balls and each box has certain number of cricket balls (non-zero) in it. The boxes are numbered from 1 to N.*/

/*Now, Daksh has to go for practicing to cricket ground to compete in the upcoming fest URJA. Daksh wants to carry exactly K number of cricket balls to ground and he can carry only 2 boxes. Can you tell him the number of ways in which he can select 2 boxes such that total number of cricket balls in them is K.*/

package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Node10{
	int freq=1;
	boolean visited;
}

public class CricketBalls {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0) {
			Map<Integer,Node10> map=new HashMap<>();
			int n=s.nextInt();
			for(int i=0;i<n;i++) {
				int key=s.nextInt();
				map.computeIfPresent(key, (k,value) -> {
					value.freq++;
					return value;
				});
				map.computeIfAbsent(key, k -> {return new Node10();});
			}
			int k=s.nextInt();
			
			System.out.println(findAnswer(map,k));
		}
	}

	private static int findAnswer(Map<Integer,Node10> map, int k) {
		int count=0;
		for(Map.Entry<Integer, Node10> entry: map.entrySet()) {
			int key=entry.getKey();
			int keyToSearch= k-key;
			Node10 obj= map.get(keyToSearch);
			
			if(obj==null) {
				entry.getValue().visited=true;
			} 
			else if(!obj.visited){
				if(entry.getValue().equals(obj)) {
					if(obj.freq!=1)
						count+= getAns(obj.freq);
					obj.visited=true;
				}else {
				count+= (entry.getValue().freq* obj.freq);
				entry.getValue().visited=true;
				obj.visited=true;
			}}
		}
		
		return count;
		
	}

	private static int getAns(int freq) {
		if(freq==1)
			return 0;
		else {
			return ((freq-1)*(freq))/2;
		}
	}
}
