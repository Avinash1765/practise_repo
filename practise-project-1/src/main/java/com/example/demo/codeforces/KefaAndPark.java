package com.example.demo.codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class KefaAndPark {
	
	static int globalM= 0;
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int n= s.nextInt();
		int m=s.nextInt();
		
		globalM= m;
		
		boolean catArr[]= new boolean[n+1];
		
		for(int i=1;i<=n;i++)
			catArr[i]= (s.nextInt() ==1);
		
		GNode vertexArr[]= new GNode[n+1];
		
		for(int i=1;i<=n;i++) {
			vertexArr[i]= new GNode(i+1);
		}
		
		for(int i=0;i<n-1;i++) {
			int st= s.nextInt();
			int end= s.nextInt();
			vertexArr[st].neighbours.add(end);
			vertexArr[end].neighbours.add(st);

			//vertexArr[Math.min(st, end)].neighbours.add(Math.max(st, end));
		}
		
		boolean visitedArr[]= new boolean[n+1];
		
		System.out.println(countResto(vertexArr, visitedArr, catArr, 1, (catArr[1] ? m-1 : m)));
		
	}

	private static int countResto(GNode[] vertexArr, boolean visitedArr[], boolean[] catArr, int currentNode, int m) {
		
		int totalResto= 0;
		
		if(getUnvisitedNeighbours(vertexArr, currentNode, visitedArr).size()==0) {
			return 1;
		}
		
		visitedArr[currentNode]= true;
		
		for(Integer neighbourNode: getUnvisitedNeighbours(vertexArr, currentNode, visitedArr)) {
			if(m==0 && catArr[neighbourNode]) {
				visitedArr[neighbourNode]= true;
				continue;
			}else {
				totalResto += countResto(vertexArr, visitedArr, catArr, neighbourNode, (catArr[neighbourNode] ? m-1 : globalM));
			}
		}
		
		
		return totalResto;
	}
	
	private static List<Integer> getUnvisitedNeighbours(GNode vertexArr[], int currentNode, boolean visitedArr[]){
		return vertexArr[currentNode].neighbours.stream().filter((ele) -> {
			return !visitedArr[ele] ;
		}).collect(Collectors.toList());
	}
	
	static class GNode{
		int ele;
		List<Integer> neighbours;
		
		public GNode(int ele) {
			this.ele= ele;
			this.neighbours= new ArrayList<>();
		}
	}

}
