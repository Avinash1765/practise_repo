package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Course implements Comparable<Course>{
	int courseId;
	int numStudentsJoined;
	List<Integer> list=new LinkedList<>();
	
	int z;
	
	public Course(int courseId) {
		this.courseId= courseId;
	}

	@Override
	public int compareTo(Course o) {
		if(z!=o.z)
			return z < o.z ? -1 : 1;
		else
			return courseId < o.courseId ? -1: 1;
		
	}
	
}

public class MonkIQ {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		int c=s.nextInt();
		int p=s.nextInt();
		int n=s.nextInt();
		
		Queue<Course> queue=new PriorityQueue<>();
		for(int i=1;i<=c;i++)
			queue.add(new Course(i));
		// n students
		String str=s.nextLine();
		
		String strArr[]=str.split("\\s+");
		int iqArr[]=new int[n];
		
		
		
		for(int i=0;i< n;i++)
			iqArr[i]= Integer.parseInt(strArr[i]);
		
		for(int i=0;i<n;i++) {
			Course course=queue.poll();
			course.numStudentsJoined++;
			if(course.list.size()<2)
				course.list.add(iqArr[i]);
			else {
				course.list.remove(0);
				course.list.add(iqArr[i]);
			}
			
			int x=0;
			if(course.list.size()==1)
				x=course.list.get(0);
			else
				x+= (course.list.get(0) + course.list.get(1));
			course.z= course.numStudentsJoined * x;
			
			queue.add(course);
				
		}
		
		// monk group
		String st=s.nextLine();
		String monkA[]=st.split("\\s+");
		
		int monkArr[]= new int[p];
		
		for(int i=0;i< p;i++)
			monkArr[i]= Integer.parseInt(monkA[i]);
		
		
		for(int i=0;i<p;i++) {
			Course obj=queue.poll();
			System.out.print(obj.courseId+" ");
			obj.numStudentsJoined++;
			
			if(obj.list.size()<2)
				obj.list.add(monkArr[i]);
			else {
				obj.list.remove(0);
				obj.list.add(monkArr[i]);
			}
			
			int x=0;
			if(obj.list.size()==1)
				x=obj.list.get(0);
			else
				x+= (obj.list.get(0) + obj.list.get(1));
			obj.z= obj.numStudentsJoined * x;
			
			queue.add(obj);
			
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
