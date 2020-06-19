package com.example.demo;

import java.util.Scanner;

class Node5 {
	Node5 arr[]=new Node5[26];
	boolean endOfWord;
	
}

public class Trie {

	public static void main(String[] args) {
		Trie obj=new Trie();
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0) {
			int numWords=s.nextInt();
		
		String arr[]=new String[numWords];
		for(int i=0;i< numWords;i++) {
			arr[i]=s.next();
		}
		
		Node5 root =new Node5();
		
		for(String str: arr) {
			root=obj.insert(root,str);
		}
		
		String toFind= s.next();
		
		System.out.println(obj.search(root, toFind));
		t--;
		}
		
		s.close();
	}

	private int search(Node5 root, String str) {
		for(char ch: str.toCharArray()) {
			
			if(root.arr[ch-97]==null)
				return 0;
			root=root.arr[ch-97];
			
		}
		if(root.endOfWord)
			return 1;
		return 0;
	}

	private Node5 insert(Node5 root, String str) {
		Node5 temp=root;
		for(char ch: str.toCharArray()) {
			
			if(temp.arr[ch-97]==null)
				temp.arr[ch-97]=new Node5();
			temp=temp.arr[ch-97];
			
		}
		temp.endOfWord=true;
		return root;
	}
}
