package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Node27{
	int value,index;
	
	public Node27(int value, int index) {
		this.value= value;
		this.index= index;
	}
}

public class MonkAndSwaps {
	
	private List<Integer> inorderList=new ArrayList<>();
	
	public static void main(String[] args) {
		FastReader s=new FastReader();
		
		int n=s.nextInt();
		int arr[]=new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i]=s.nextInt();
		}
		MonkAndSwaps obj=new MonkAndSwaps();
		obj.inorder(arr, 1, n+1);
		
		
		final List<Node27> list= new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			list.add(new Node27(obj.inorderList.get(i), i));
		}
		
		list.sort(new Comparator<Node27>() {

			@Override
			public int compare(Node27 o1, Node27 o2) {
				return o1.value - o2.value;
			}
		});
		
		int count=0;
		for(int i=0;i<n;i++) {
			if(list.get(i).index == i)
				continue;
			else {
				while(list.get(i).index != i) {
					Node27 temp = list.get(i);
					
					list.set(i, list.get(list.get(i).index));
					list.set(temp.index, temp);
					count++;
				}
			}
		}
		
		System.out.println(count);
		
		
		
		
		
	}
	
	private void inorder(int[] arr, int index, int size) {
		if(!(index <1 || index >=size)) {
			inorder(arr, index*2, size);
			inorderList.add(arr[index]);
			inorder(arr, index*2 +1, size);
		}
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
