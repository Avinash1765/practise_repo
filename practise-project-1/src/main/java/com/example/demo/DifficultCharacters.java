package com.example.demo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Node13{
	char ch;
	int freq;
	
	@Override
	public boolean equals(Object obj) {
		Node13 obj1=(Node13)obj;
		return obj1.ch==ch;
	}
	
	public int hashCode() {
		return ch;
	}
	
	public Node13(char ch) {
		this.ch=ch;
	}
}

class Node13Comparator implements Comparator<Node13>{

	@Override
	public int compare(Node13 o1, Node13 o2) {
		if(o1.freq==o2.freq)
			return -1*(o1.ch-o2.ch);
		return (o1.freq-o2.freq);
	}
	
}

public class DifficultCharacters {

	public static void main(String[] args) {
		
		//Queue<Node13> queue=new PriorityQueue<>(new Node13Comparator());
		Set<Node13> set=new TreeSet<>(new Node13Comparator());
		Map<Character, Node13> map=new HashMap<>();
		
		
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		
		while(t-->0) {
			String str= s.next();
			set.clear();
			map.clear();
			for(char ch='a';ch<='z';ch++) {
				Node13 obj=new Node13(ch);
				map.put(ch, obj);
			}
			for(char ch: str.toCharArray()) {
				map.get(ch).freq++;
			}
			
			for(Map.Entry<Character, Node13> entry: map.entrySet()) {
				set.add(entry.getValue());
			}
			
			for(Node13 obj: set) {
				System.out.print(obj.ch+ " ");
			}
			System.out.println();
		}
		
	}

}
