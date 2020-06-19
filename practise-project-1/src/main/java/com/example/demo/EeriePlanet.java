package com.example.demo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Crew {
	int height,start,end;

	public Crew(int height, int start, int end) {
		super();
		this.height = height;
		this.start = start;
		this.end = end;
	}
	
}

class CrewComparator implements Comparator<Crew>{

	@Override
	public int compare(Crew obj1, Crew obj2) {
		if((obj1.end-obj1.start)>(obj2.end-obj2.start))
			return -1;
		else
			return 1;
	}
	
}
public class EeriePlanet {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int h=s.nextInt();
		int crewNum= s.nextInt();
		int maxheight=0;
		int q=s.nextInt();
	//	Crew crew[]=new Crew[crewNum];
		Queue<Crew> crew=new PriorityQueue<>(new CrewComparator());
		for(int i=0;i<crewNum;i++) {
			Crew obj=new Crew(s.nextInt(),s.nextInt(),s.nextInt());
			maxheight= Math.max(maxheight, obj.height);
			crew.add(obj);
		}
		
		while(q-->0) {
			
			int personHeight= s.nextInt();
			int personTime= s.nextInt();
			if(personHeight>maxheight) {
				System.out.println("YES");
				continue;
			}
			boolean flag=false;
			Iterator<Crew> itr=crew.iterator();
			while(itr.hasNext()) {
				Crew obj= itr.next();
				if(personTime>=obj.start && personTime<=obj.end && personHeight<=obj.height) {
					flag= true;
					break;
				}
			}
			if(flag)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}

}
