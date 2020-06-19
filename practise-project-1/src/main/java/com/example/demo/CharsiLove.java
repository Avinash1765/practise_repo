package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharsiLove {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		
		List<Integer> list=new ArrayList<>();
		
		list.add(1);
		
		int ele=1;
		int i=1;
		while(ele <=1000000000) {
			list.set(i, list.get(i-1) +(ele++));
		}
	}

}
