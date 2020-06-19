package com.example.demo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Node1{
	int vertex;
	LinkedList<Integer> arr[];
	
	public Node1(int numNodes) {
		arr=new LinkedList[numNodes];
		for(int i=0;i<numNodes;i++) {
			arr[i]=new LinkedList<>();
		}
	}

	public void addEdge(int source, int destination) {
		arr[source].add(destination);
	}

	public void printConnectedComponents(int numNodes) {
		
		boolean firstVisit=true;
		
		Boolean visited[]=new Boolean[numNodes];
		Arrays.fill(visited, false);
		LinkedList<Integer> queue=new LinkedList<>();
		
		while(ifUnvisitedNodesPresent(visited)) {
			if(firstVisit) {
				queue.add(0);
				firstVisit=false;
			}else {
				int ind=-1;
				for(int i=0;i<visited.length;i++) {
					if(visited[i]==false) {
						ind=i;
						break;
					}
				}
				if(ind>=0)
					queue.add(ind);
			}
		while(!queue.isEmpty()) {
			int n=queue.poll();
			
			System.out.print(n+" ");
			visited[n]=true;
			Iterator itr=arr[n].iterator();
			
			while(itr.hasNext()) {
				int ele=(int)itr.next();
				if(!visited[ele]) {
					visited[ele]=true;
					queue.add(ele);
				}
				
			}
			
			
		}
		System.out.println();
		}
	}

	private boolean ifUnvisitedNodesPresent(Boolean visited[]) {
		return Arrays.asList(visited).contains(Boolean.FALSE);
		
	}
}
public class ConnectedComponents {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int numNodes=s.nextInt();
		
		Node1 object=new Node1(numNodes);
		
		int edges=s.nextInt();
		
		for(int i=0;i<edges;i++) {
			
			int source=s.nextInt();
			int destination=s.nextInt();
		
			object.addEdge(source,destination);
	}
		
		object.printConnectedComponents(numNodes);
		
		
		
	}
}
