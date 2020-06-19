package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CompareStrings {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		
		int n=s.nextInt();int q=s.nextInt();
		
		StringBuilder a=new StringBuilder(s.next());
		StringBuilder b=new StringBuilder(s.next());
		int diffIndex=0;
		
		for(int i=0;i<n;i++) {
			if(b.charAt(i)=='0' && a.charAt(i)=='1') {
				diffIndex=i;
				break;
			}
		}
		
		
		while(q-->0) {
			int ind=s.nextInt()-1;
			
			b.setCharAt(ind, '1');
			
			if(ind != diffIndex) {
				System.out.println("NO");
			}else {
				diffIndex=updateDiffIndex(a,b, ind);
				if(diffIndex !=-1)
					System.out.println("NO");
				else
					System.out.println("YES");
			}
			
			/*if(b.toString().compareTo(a.toString()) <0)
				System.out.println("NO");
			else
				System.out.println("YES");*/
		}
		
		
	}
	
	private static int updateDiffIndex(StringBuilder a, StringBuilder b, int ind) {
		int size= a.length();
		if(ind==size-1)
			return -1;
		else {
			for(int i=ind;i<size;i++) {
				if(b.charAt(i)=='0' && a.charAt(i)=='1') {
					return i;
				}
			}
		}
		return -1;
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
