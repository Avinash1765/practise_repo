package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Topic{
	long id, z, p, l, c, s;
	long scoreChange=0, newScore=0;
	
	@Override
	public boolean equals(Object ob) {
		Topic obj= (Topic)ob;
		return obj.id== this.id;
	}
	
	
	public Topic(long id, long z,long p,long l,long c,long s) {
		this.id=id;
		this.z= z;
		this.p=p;
		this.l=l;
		this.c=c;
		this.s=s;
	}
	
}

class TopicComparator implements Comparator<Topic>{

	@Override
	public int compare(Topic t1, Topic t2) {
		
		long v=t2.scoreChange- t1.scoreChange;
		
		if(v==0)
			return new Long(t2.id- t1.id).intValue();
		else
			return new Long(v).intValue();
		
		
	}
	
}

public class RoyandTrendingTopics {

	public static void main(String[] args) {
		FastReader s=new FastReader();
		
		int n=s.nextInt();
		
		List<Topic> topicList=new ArrayList<>();
		
		while(n-->0) {
			topicList.add(new Topic(s.nextLong(), s.nextLong(), s.nextLong(), s.nextLong(), s.nextLong(),s.nextLong()));
		}
		
		Queue<Topic> trendingTopics= new PriorityQueue<>(new TopicComparator());
		
		for(Topic topic: topicList) {
			
			long val= (topic.p)*50 + (topic.l)*5 + (topic.c)*10 + (topic.s) * 20;
			topic.scoreChange= val- topic.z;
			topic.newScore= val;
			trendingTopics.add(topic);
		}
		
		int k=5;
		
		while(k-->0) {
			Topic obj=trendingTopics.poll();
			System.out.println(obj.id +" "+obj.newScore);
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
