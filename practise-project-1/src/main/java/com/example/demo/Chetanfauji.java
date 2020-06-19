package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node16{
	int x,y;
	
	public Node16(int x,int y) {
		this.x=x;
		this.y=y;
	}
}

public class Chetanfauji {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		List<Node16> list=new ArrayList<>();
		
		int n=s.nextInt();
		int t=n;
		while(t-->0) {
			list.add(new Node16(s.nextInt(), s.nextInt()));
		}
		int su=s.nextInt();
		int count=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if((list.get(i).x - list.get(j).x) + (list.get(i).y - list.get(j).y )==su )
					count++;
			}
		}
		System.out.println(count);
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
