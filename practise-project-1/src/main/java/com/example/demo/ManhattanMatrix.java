package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class ManhattanMatrix {

	public static void main(String[] args) {
		 FastReader s=new FastReader();
		 int t=s.nextInt();
		 
		 while(t-->0) {
			 int n=s.nextInt();
			 int m=s.nextInt();
			 
			 int arr[][]=new int[n][m];
			 
			 for(int i=0;i<n;i++) {
				 String str[]=s.nextLine().split(" ");
				 
				 for(int j=0;j<m;j++) {
					 arr[i][j]=Integer.parseInt(str[j]);
				 }
			 }
			 
			 int startX=s.nextInt()-1;
			 int startY=s.nextInt()-1;
			 
			 
			 
			 int q=s.nextInt();
			 
			 while(q-->0) {
				 int destX=s.nextInt()-1;
				 int destY=s.nextInt()-1;
				 
				 boolean visited[][]=new boolean[n][m];
				 
				 System.out.println(findMoves(arr, startX, startY, destX, destY,n,m, visited));
			 }
		 }
	}
	
	private static int findMoves(int[][] arr, int startX, int startY, int destX, int destY, int n, int m, boolean visited[][]) {
		
		if(startX== destX && startY == destY)
			return 0;
		
		List<Pair> nextValidPoints=findNextValidPoints(arr,startX, startY, n, m, visited);
		
		if(nextValidPoints.size()==0)
			return -1;
		
		int min=Integer.MAX_VALUE;
		
		for(Pair obj : nextValidPoints) {
			int retVal=findMoves(arr, obj.x, obj.y, destX, destY, n, m, visited);
			
			if(retVal!=-1 && retVal != Integer.MAX_VALUE) {
				int val= retVal+1;
			if(val < min && val!=-1)
				min= val;
			}
		}
		
		return min== Integer.MAX_VALUE ? -1 : min;
	}

	private static List<Pair> findNextValidPoints(int arr[][], int startX, int startY, int n, int m, boolean visited[][]) {
		int presVal= arr[startX][startY];
		
		HashSet<Pair> set= new HashSet<>();
		
		for(int i=0;i<=presVal;i++) {
			set.add(new Pair( startX + i, startY + (presVal - i)));
			set.add(new Pair( startX-i, startY - (presVal -i)));
			set.add(new Pair( startX-i, startY + (presVal -i)));
			set.add(new Pair( startX+i, startY - (presVal -i)));
		}
		
		List<Pair> list=new ArrayList<>();
		
		for(Pair ob : set) {
			/*int xe= startX+ob.x;
			int ye= startY+ob.y;*/
			int xe= ob.x;
			int ye= ob.y;
			if(xe>=0 && ye >=0 && xe<n && ye < m && !visited[xe][ye]) {
				
				if(Math.abs(startX - xe) + Math.abs(startY - ye) == arr[startX][startY]) {
					visited[xe][ye]= true;
					list.add(new Pair(xe, ye));
				}
			}
		}
		return list;
	}
	
	/*static Predicate<Pair> predicte= (Pair obj)-> {
		if()
	};*/
	
	static class Pair{
		int x,y;
		
		public Pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(x,y);
		}
		
		public boolean equals(Object obj) {
			Pair p1= (Pair)obj;
			
			return this.x== p1.x && this.y== p1.y;
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
