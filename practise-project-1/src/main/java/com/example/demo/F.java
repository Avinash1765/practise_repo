package com.example.demo;

import java.util.LinkedList;
import java.util.Queue;

public class F {

	public static void main(String[] args) {
		LinkedList<Integer> queue=new LinkedList<>();
		
		queue.add(21);
		queue.add(3);
		queue.add(9);
		queue.add(11);
		System.out.println(queue);
		
		queue.remove(1);
		System.out.println(queue);
		
		
	}

}
