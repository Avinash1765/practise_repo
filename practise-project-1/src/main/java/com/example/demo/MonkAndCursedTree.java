package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Node28{
	long data;
	Node28 left,right;
	
	public Node28(long data) {
		this.data= data;
	}
}

public class MonkAndCursedTree {
	
	static List<Long> firstElePath=new ArrayList<>();
	static List<Long> secondElePath=new ArrayList<>();
	

	public static void main(String[] args) {
		FastReader s=new FastReader();
		int n=s.nextInt();
		
		Node28 root= new Node28(s.nextLong());
		
		while(n-->1) {
			root=insert(root, s.nextLong());
		}
		
		
		//inorder(root);
		
		long firstEle= s.nextLong();
		long secondEle= s.nextLong();
		
		getPathFromRoot(root,firstEle, firstElePath);
		getPathFromRoot(root,secondEle, secondElePath);
		
		int i=0;
		int firstSize= firstElePath.size();
		int secondSize= secondElePath.size();
		
		while(i<firstSize && i<secondSize) {
			if(firstElePath.get(i).longValue() != secondElePath.get(i).longValue()) {
				break;
			}
			i++;
		}
		long max=Integer.MIN_VALUE;
		int smallListFlag=0;
		if(i== firstSize) {
			max= firstElePath.get(i-1);
			smallListFlag+= 1;
		}
		
		if(i== secondSize) {
			max= secondElePath.get(i-1);
			smallListFlag+= 2;
		}
		
		if(smallListFlag ==0) {
			max= firstElePath.get(i-1);
			
			long maxFromFirst= Collections.max(firstElePath.subList(i, firstSize));
			max= Math.max(Collections.max(secondElePath.subList(i, secondSize)), maxFromFirst);
			
		}else if(smallListFlag ==2) {
			max= Math.max(Collections.max(firstElePath.subList(i, firstElePath.size())), max);
		}else if(smallListFlag == 1) {
			max= Math.max(Collections.max(secondElePath.subList(i, secondSize)), max);
		}
		
		System.out.println(max);	
		
		
	}
	
	private static void getPathFromRoot(Node28 root, long element, List<Long> list) {
		if(root.data == element) {
			list.add(root.data);
			return;
		}
		
		else if(element < root.data) {
			list.add(root.data);
			getPathFromRoot(root.left, element, list);
		}
		
		else {
			list.add(root.data);
			getPathFromRoot(root.right, element, list);
		}
	}

	/*private static void inorder(Node28 root) {
		if(root!=null) {
			inorder(root.left);
			System.out.print(root.data+ " ");
			inorder(root.right);
		}
	}*/
	
	private static Node28 insert(Node28 root, long ele) {
		//Node28 temp = root;
		
		if(ele < root.data) {
			if(root.left == null) {
			root.left= new Node28(ele);
			}else {
				insert(root.left, ele);
			}
		}
		else {
			if(root.right == null) {
				root.right= new Node28(ele);
				}else {
					insert(root.right, ele);
				}
		}
		
		return root;
	}

	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 

}
