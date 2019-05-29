package com.example.demo;

import java.util.Scanner;

public class HundredDaysFromToday {
public static void main(String[] args) {
	

	Scanner s=new Scanner(System.in);
	int d=s.nextInt();
	int m=s.nextInt();
	int y=s.nextInt();
	int temp=y+1;
	int month[]= {31,28,31,30,31,30,31,31,30,31,30,31};
	
	boolean nextYearLeap= isLeapYear(temp);
	boolean presentYearLeap= isLeapYear(y);
	
	int daysFromStartOfYear=0;
	int monthDays=0;
	for(int i=0;i< m-1;i++) {
		if(m==1) {
			monthDays= 0;
			break;
		}else
			monthDays+= month[i];
	}
	daysFromStartOfYear= d+ monthDays;
	
	int after100Days= daysFromStartOfYear + 100;
	
	if(presentYearLeap && ((m==2 && d<=28) || m==1))
		--after100Days;
	
	int daysInNextYear= -1;
	
	if(after100Days>365 && !presentYearLeap) {
		daysInNextYear= after100Days-365;
	}
	if(after100Days>366 && presentYearLeap) {
		daysInNextYear= after100Days-366;
	}
	int d1,m1,y1,i;
	d1=m1=y1=i=0;
	if(daysInNextYear!=-1) {
		for(;i<12;i++) {
			if(nextYearLeap && i==1 && daysInNextYear>29)
				daysInNextYear-=29;
			else if(daysInNextYear>month[i])
				daysInNextYear-=month[i];
			else
				break;
		}
		m1=(++i);
		y1=y+1;
		d1=daysInNextYear;
	}
	else {
		y1=y;
		for(;i<12;i++) {
			if(after100Days>month[i])
				after100Days-=month[i];
			else
				break;
		}
		d1=after100Days;
		m1=(++i);
	}
	
	System.out.println("After 100 days its "+ d1+"-"+m1+"-"+y1);
	s.close();
	
}

private static boolean isLeapYear(int num) {
	if(num%400==0 || (num%4==0 && num%100!=0))
		return true;
	return false;
}
}