package com.example.demo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Problem1128 {

	public static void main(String[] args) {
		Problem1128 obj= new Problem1128();
		int arr[][]= {{1,2},{2,1},{3,4},{5,6}};
		
		System.out.println(obj.numEquivDominoPairs(arr));
	}
	
	 public int numEquivDominoPairs(int[][] dominoes) {
	        Set<Node> set= new HashSet<>();
	        
	        int n= dominoes.length;
	        int cnt=0;
	        
	        for(int i=0;i<n;i++){
	            Node obj=new Node(dominoes[i][0], dominoes[i][1]);
	            
	            if(set.contains(obj)){
	                cnt++;
	            }else
	                set.add(obj);
	        }
	        
	        return cnt;
	    }
	    
	    static class Node {
	        int a,b;
	        
	        public Node(int a, int b){
	            this.a= (a<=b ? a: b);
	            this.b= (a>b ? a: b);
	        }
	        
	        public boolean equals(Object ot){
	            if(this==ot)
	                return true;
	            if(ot==null)
	                return false;
	            if(getClass() != ot.getClass())
	                return false;
	            
	            Node other= (Node)ot;
	            
	            return other.a== this.a && other.b== this.b;
	        }
	        
	        public int hashCode(){
	            return new Integer(new Integer(a).toString().concat(new Integer(b).toString())).intValue();
	        	//return Objects.hash(a,b);
	        }
	    }

}
