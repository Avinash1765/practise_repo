package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*(I)Print pattern(for N=4)

1
3*2
4*5*6
10*9*8*7*/

/**
 * @author atadiboy
 *
 */
public class PatternCreator {

	public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		int num=s.nextInt();
		String str="";
		int count=0;
		
		for(int i=0;i<num;i++) {
			for(int j=0;j<=i;j++) {
				count++;
				str=str.concat(new Integer(count).toString());
				str=str.concat("*");
			}
			str=str.concat("\n");
		}
		String arr[]=str.split("\n");
		List<String> stringList=new ArrayList<>();
		
		Arrays.asList(arr).forEach(obj->{
			stringList.add(obj.substring(0, obj.length()-1));
		});
		
		
		for(int i=0;i<stringList.size();i++) {
			if(i%2==1) {
				String st=stringList.get(i);
				String arrt[]=st.split("\\*");
				List<String> strList=Arrays.asList(arrt);
				Collections.reverse(strList);
				strList.toArray(arrt);
				stringList.set(i, String.join("*", arrt));
				
			}
		}
		stringList.forEach(System.out::println);
	}

}
