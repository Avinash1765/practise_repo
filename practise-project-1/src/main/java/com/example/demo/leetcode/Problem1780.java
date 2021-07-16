package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1780 {
	Set<Integer> powerSelected= new HashSet<>();
	 List<Integer> pow3Values= new ArrayList<>();
	    int size=0;
	    
	    private void preProcess(){
	    	powerSelected.rem
	        int maxVal= 10000000;
	        
	        int exp=0;
	        int val=0;
	        while(val<=maxVal){
	            val=(int)Math.pow(3,exp);
	            
	            pow3Values.add(val);
	            exp++;
	            size++;
	        }
	        
	        
	    }
	    public boolean checkPowersOfThree(int n) {
	        
	        if(n==0 || checkPow3Values(n))
	            return true;
	        
	        for(int i=0;i<size;i++){
	            boolean flag=checkPowersOfThree(n-pow3Values.get(i));
	            if(flag)
	                return true;
	        }
	        
	        return false;
	    }
	    
	    private boolean checkPow3Values(int n){
	        while(n!=0){
	            if(n%3==0)
	                n/=3;
	            else
	                return false;
	        }
	        
	        return true;
	    }
	    
	public static void main(String[] args) {

	}

}
