package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Node2{
	
LinkedList<Integer> arr[];
	
	//@SuppressWarnings("unchecked")
	public Node2(int numNodes) {
		arr=new LinkedList[numNodes+1];
		for(int i=0;i<numNodes+1;i++) {
			arr[i]=new LinkedList<>();
		}
	}
	
	public void addEdge(int source, int destination) {
		arr[source].add(destination);
	}

	//@SuppressWarnings("unchecked")
	public void printConnectedComponents(int vertices,int k) {
		LinkedList<Integer> finalArr[]=(LinkedList[])new LinkedList[vertices];
		
		Boolean visited[]=new Boolean[vertices+1];
		Arrays.fill(visited, false);
		LinkedList<Integer> queue=new LinkedList<>();
		int finalIndex=0;
		while(ifUnvisitedNodesPresent(visited)) {
			
			
				int ind=-1;
				for(int i=1;i<visited.length;i++) {
					if(visited[i]==false) {
						ind=i;
						break;
					}
				}
				if(ind>=0)
					queue.add(ind);
				finalArr[finalIndex]=new LinkedList<>();
			while(!queue.isEmpty()){
				
				
				int n=queue.poll();
				
				//System.out.print(n+" ");
				finalArr[finalIndex].add(n);
				visited[n]=true;
				Iterator<Integer> itr=arr[n].iterator();
				
				while(itr.hasNext()) {
					int ele=(int)itr.next();
					if(!visited[ele]) {
						visited[ele]=true;
						queue.add(ele);
					}
					
				}
			}
			finalIndex++;
		}
		
		int count=0;
		finalIndex=0;
		while(finalArr[finalIndex]!=null && !finalArr[finalIndex].isEmpty()) {
			if(finalArr[finalIndex].size()>=k)
				count++;
			finalIndex++;
		}
		System.out.println(count);
		finalIndex=0;
		while(finalArr[finalIndex]!=null && !finalArr[finalIndex].isEmpty()) {
			if(finalArr[finalIndex].size()>=k) {
				Collections.sort(finalArr[finalIndex]);
				System.out.print(finalArr[finalIndex].get(k-1)+" ");
			}
			finalIndex++;
		}
		
	}
	
	private boolean ifUnvisitedNodesPresent(Boolean visited[]) {
		List<Boolean> list=Arrays.asList(visited);
		list=list.subList(1, list.size());
		return list.contains(Boolean.FALSE);
		
	}
}



public class TestClass1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int vertices=s.nextInt();
        
        Node2 object=new Node2(vertices);
        
        int edges=s.nextInt();
        
        int k=s.nextInt();
        
        for(int i=0;i<edges;i++) {
        	int source=s.nextInt();
        	int destination=s.nextInt();
        	
        	object.addEdge(source, destination);
        	object.addEdge(destination, source);
        }
        
        object.printConnectedComponents(vertices,k);
	}

}
