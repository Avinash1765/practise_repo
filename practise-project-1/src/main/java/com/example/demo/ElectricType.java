package com.example.demo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class Node18{
	int x,y;
	
	public Node18(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	@Override
	public boolean equals(Object ob) {
		Node18 obj=(Node18)ob;
		return obj.x==this.x && obj.y==this.y;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x,y);
	}
}

public class ElectricType {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		/*Map<Integer, Integer> map=new HashMap<>();
		while(n-->0) {
			int ele=s.nextInt();
			map.computeIfPresent(ele, (k,v)-> v+1);
			map.computeIfAbsent(ele, k -> 1);
		}
		
		List<Map.Entry<Integer, Integer>> list=new ArrayList<>(map.entrySet());
		int size=list.size();*/
		
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++)
			arr[i]=s.nextInt();
		
		Set<Node18> set=new HashSet<>();
		
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j< n;j++) {
				set.add(new Node18(arr[i], arr[j]));
			}
		}
		System.out.println(set.size());
		
		
	}

}
