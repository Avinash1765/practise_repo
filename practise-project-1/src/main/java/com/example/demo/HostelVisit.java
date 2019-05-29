package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
	int x,y;
	
	public Point(int x ,int y) {
		this.x=x;
		this.y=y;
	}
	
}

class PointComp implements Comparator<Point>{

	@Override
	public int compare(Point o1, Point o2) {
		return ((o1.x*o1.x)+ (o1.y*o1.y)) -((o2.x*o2.x)+ (o2.y*o2.y));
	}
	
}
public class HostelVisit {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		
		int q=s.nextInt();
		int k=s.nextInt();
		k--;
		Queue<Point> queue=new PriorityQueue<>(new PointComp());
		while(q-->0) {
			int temp=k;
			int opt=s.nextInt();
		switch(opt) {
			case 1:
				int x=s.nextInt();
				int y=s.nextInt();
				queue.add(new Point(x,y));
				break;
			case 2:
				List<Point> list=new ArrayList<>();
				while(temp-->0) {
					list.add(queue.poll());
				}
				Point og=queue.peek();
				System.out.println(og.x*og.x + og.y*og.y);
				for(Point qwe : list)
					queue.add(qwe);
		}
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
