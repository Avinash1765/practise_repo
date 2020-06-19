package com.example.demo;
import java.io.*;
import java.util.*;



class HiddenNumber {
    public static void main(String args[] ) throws Exception {
        
        Scanner s = new Scanner(System.in);
        int t=s.nextInt();
        
        while(t-->0){
            int n=s.nextInt();
            long sum=0;
            for(int i=0;i<n;i++){
               sum+= s.nextLong();
            }
            
            System.out.println(sum/ n);
            
        }
        


    }
}
