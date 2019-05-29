package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Node17{
	int index;
	String str;
	
	public Node17(int index, String str) {
		this.index= index;
		this.str= str;
	}
}

public class LongLong {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.next();
		int n=str.length();
		List<Node17> stringList=new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			stringList.add(new Node17(i,str.substring(i)));
		}
		
		Collections.sort(stringList, new Comparator<Node17>() {

			@Override
			public int compare(Node17 o1, Node17 o2) {
				return o1.str.compareTo(o2.str);
			}
		});
		
		int suffixArray[]=new int[stringList.size()];
		int rank[]=new int[stringList.size()];
		int k=0;
		
		for(int i=0;i<suffixArray.length;i++)
			suffixArray[i]= stringList.get(i).index;
		
		for(int i=0;i<n;i++)
			rank[suffixArray[i]] = i;
		
		for(int i=0;i<n;i++) {
			if(rank[i]==n-1) {
				k=0;
				continue;
			}
			
			int j = suffixArray[rank[i]+1];
			
			while (i+k<n && j+k<n && txt[i+k]==txt[j+k]) 
	            k++; 
	  
	        lcp[invSuff[i]] = k; // lcp for the present suffix. 
	  
	        // Deleting the starting character from the string. 
	        if (k>0) 
	            k--;
		}
		
		
	}

}
