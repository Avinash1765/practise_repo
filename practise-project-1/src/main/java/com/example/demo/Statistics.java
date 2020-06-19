package com.example.demo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
class Node11{
	String game;
	int freq=1;
	
	@Override
	public boolean equals(Object obj) {
		Node11 other=(Node11)obj;
		return game.equals(other.game);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(game);
	}
	
	public Node11(String game) {
		this.game= game;
	}
}

class Node11Comparator implements Comparator<Node11> {

	@Override
	public int compare(Node11 o1, Node11 o2) {
		return o2.freq-o1.freq;
	}
	
}

class Statistics {
    public static void main(String args[] ) throws Exception {
        
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        Set<String> nameSet=new HashSet<>();
        Map<String,Node11> nodeMap=new HashMap<>();
        Set<Node11> nodeSet= new TreeSet<>(new Node11Comparator());
        while(n-->0) {
        	String name = s.next();
        	String game= s.next();
        	if(!nameSet.contains(name)) {
        		nodeMap.computeIfPresent(game, (k,v)-> {
        			Node11 obj=v;
        			obj.freq++;
        			return obj;
        		});
        		nodeMap.computeIfAbsent(game, (k) -> new Node11(game));
        		nameSet.add(name);
        	}
        }
        int footballCount= nodeMap.get("football") !=null ? nodeMap.get("football").freq : 0;
        nodeMap.entrySet().forEach(obj -> {
        	nodeSet.add(obj.getValue());
        });
        
        System.out.println(nodeSet.iterator().next().game);
        System.out.println(footballCount);
        
    }
        
        
}

