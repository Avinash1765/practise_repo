package com.example.demo;

import java.util.Scanner;

class ColuredNode{
	int parent, color;
	
	public ColuredNode(int parent) {
		this.parent= parent;
	}
	
	public ColuredNode(int parent, int color) {
		this.parent= parent;
		this.color= color;
	}
}

public class MancunianAndColoredTree {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		int c=s.nextInt();
		
		ColuredNode arr[]=new ColuredNode[n];
		int parent[]=new int[n-1];
		int colour[]=new int[n];
		for(int i=0;i<n-1;i++) {
			 parent[i] =s.nextInt();
			
		}
		for(int i=0;i<n;i++) {
			 colour[i] =s.nextInt();
			
		}
		
		arr[0]=new ColuredNode(-1);
		arr[0].color= colour[0];
		
		
		
		
		for(int i=0;i<n-1;i++) {
			int paren =parent[i];
			int colo= colour[i+1];
			arr[i+1]=new ColuredNode(paren, colo);
		}
		
		System.out.print(-1+" ");
		
		for(int i=1;i<n;i++) {
			int presentNodeColor= arr[i].color;
			int presentParent=arr[i].parent;
			while(presentParent>0 && arr[presentParent-1]!= null && arr[presentParent-1].color!= presentNodeColor) {
				presentParent= arr[presentParent-1].parent;
			}
			
			System.out.print(presentParent+" ");
		}
		
		
	}

}
