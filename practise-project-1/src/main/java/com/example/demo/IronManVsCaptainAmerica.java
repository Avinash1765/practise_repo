package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IronManVsCaptainAmerica {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		int t=s.nextInt();
		
		while(t-->0) {
			int n=s.nextInt();
			
			int track1[]=new int[n];
			int track2[]=new int[n];
			int onetwo[]=new int[n-1];
			int twoone[]=new int[n-1];
			
			String arr[]=s.nextLine().split(" ");
			
			for(int i=0;i<n;i++)
				track1[i]=Integer.parseInt(arr[i]);
			
			arr= s.nextLine().split(" ");
			
			for(int i=0;i<n;i++)
				track2[i]=Integer.parseInt(arr[i]);
			
			arr=s.nextLine().split(" ");
			
			for(int i=0;i<n-1;i++)
				onetwo[i]=Integer.parseInt(arr[i]);
			
			arr=s.nextLine().split(" ");
			
			for(int i=0;i<n-1;i++)
				twoone[i]=Integer.parseInt(arr[i]);
			
			//boolean presentTrack=false;
			
			// true --> 1st track ,,,,   false --> 2nd track
			
			long totalCos1[]= new long[n];
			long totalCos2[]= new long[n];
			
			/*else {
			presentTrack=(track1[0] < track2[0]);
			}*/
			
			totalCos1[0]= track1[0];
			totalCos2[0]= track2[0];
			
			for(int i=1;i<n;i++) {
				
				long val1=0, val2=0, val3, val4;
				
					val1=totalCos1[i-1] + track1[i];
				
					val2= totalCos2[i-1] + track2[i];
				
				
				
					val3= totalCos2[i-1] + twoone[i-1]+ track1[i];
				
					val4= totalCos1[i-1] + onetwo[i-1]+ track2[i];
				totalCos1[i]=Math.min(val1, val3);
				totalCos2[i]=Math.min(val2, val4);
				
			}
			
			System.out.println(Math.min(totalCos1[n-1], totalCos2[n-1]));
			
			
			
			
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
