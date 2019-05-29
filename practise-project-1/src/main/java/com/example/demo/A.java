package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

class Parent{
	
}

class B extends Parent{
	String str="";
}

class C{
	
}

enum Player{
	Bowler,Fielder;
}
public class A {
	
	/*public void method1(Integer obj) {
		System.out.println("obj method");
	}*/
	
	public void method1(int obj) {
		String str="";
		
	}
	
	public static void print(List<?> list) {
		
		
		//new ArrayList<Integer>(list.subList(1, 2));
		ArrayList<Integer> al=new ArrayList<>();
		//al.add
		list.stream().forEach(System.out::println);
	}
	
	private static HashMap<String, String> map=new HashMap<String, String>();
	public A() {
		map.put("abc", "val");
		map.put("abc", "v");
	}
	
	public static void main(String[] args) {
		String str="Bearer aerfaefa";
		str.substring(beginIndex)
		Object ag=null;
		Object ae=ag;
		ag=new Object();
		
		System.out.println(ae);
		System.out.println(ag);
		int vg=(int)1e3;
		
		HashSet<Integer> set=new HashSet<>();
		System.out.println(set);
		setModify(set);
		System.out.println(set);
		String s1=null;
		String s2="abc";
		
		System.out.println(s1 == s2);
		System.out.println(new A().map.size());
		
		
		Set<String> set2=new HashSet<>();
		set2.add("one");
		set2.add("two");
		set2.add("three");
		
		Iterator<String> itr=set2.iterator();
		System.out.println(set2.size());
		while(itr.hasNext()) {
			String str=itr.next();
			set2.add(str.concat("a"));
		}
		System.out.println(set2.size());
		
		
		/*double fr=3.4f;
		
		System.out.println(++fr);
		HashSet<Byte> set1=new HashSet<>();
		for(byte i=1;i<100;i++) {
			set1.add(i);
			set1.remove((i-1));
		}
		
		System.out.println(set1.size());
		Integer g=3;
		new A().method1(g);
		
		List<C> blist=new ArrayList<>();
		blist.add(new C());
		
		print(blist);
		
		Function<Integer, String> func= (Integer input) -> {
			if(input%2==0)
				return "Yes";
			else
				return "No";
		};
		
		System.out.println(func.apply(3));
		
		Map<String, Map<String, String>> map=new HashMap<>();
		Map<String, String> submap=new HashMap<>();
		submap.put("subkey", "subvalue");
		map.put("key", submap);
		
		System.out.println(map.entrySet());
		
		Set<ArrayList<Integer>> set=new HashSet<>();
		
		ArrayList<Integer> list=new ArrayList<>();
		list.add(1);
		set.add(list);
		
		System.out.println(set);
		
		ArrayList<Integer> list1=new ArrayList<>();
		list1.add(1);
		
		set.contains(list1);
		
		
		
		
		
		
		
		
		
		String str="";
		
		switch(str) {
		case "c":
			System.out.println("c");
			break;
		case "abc":
			System.out.println("abc pri");
			break;
		case "":
			System.out.println("empty");
			break;
		}
		
		int ab=-3;
		System.out.println(++ab);
		Player p1= Player.valueOf("Fielder");
		Player p2= Player.valueOf("Fielder");
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		String s="aaaaaaaaaaaaaa";
		String arr1[]=s.split("b");
		System.out.println(arr1[0]);
		int arr[]= {1, 4, 20, 3, 10, 5};
		int a[][]=new int[3][4];
		//LinkedHashMap<Integer, Integer> map=new LinkedHashMap<>();
		//if(map.get(4)==null)
			
		findSubArray(arr,arr.length,33,a);*/
	}

	private static void fun1(StringBuilder st) {
		st.deleteCharAt(1);
	}

	private static void setModify(HashSet<Integer> set) {
		set.add(2);
	}

	private static void findSubArray(int[] arr, int length,int sum,int ar[][]) {
		int start=0;
		int s=arr[0];
		for(int i=1;i<length; i++) {
			
			
			while(s>sum && start<i) {
				s-=arr[start];
				++start;
			}
			
			if(s==sum) {
				System.out.println("required sum found between "+start+" and "+i);
				break;
			}
			s+=arr[i];
		}
	}

}
