package com.example.demo;
import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String[] temp = br.readLine().split(" ");
            int N = Integer.parseInt(temp[0]);
            int M = Integer.parseInt(temp[1]);
            String[] arr_chocolates = br.readLine().split(" ");
            int[] chocolates = new int[N];
            for(int i_chocolates=0; i_chocolates<arr_chocolates.length; i_chocolates++)
            {
            	chocolates[i_chocolates] = Integer.parseInt(arr_chocolates[i_chocolates]);
            }

            int out_ = solution(chocolates, M, N);
            System.out.println(out_);
         }

         wr.close();
         br.close();
    }
    static int solution(int[] chocolates, int M, int N){
        // Find the maximum number of chocolates that can be selected.
    	 int curr_sum = chocolates[0], max_sum = 0, start = 0; 
    	  
         // To find max_sum less than sum 
         for (int i = 1; i < N; i++) { 
   
             // If curr_sum becomes greater than 
             // sum subtract starting elemetns of array 
             while (curr_sum > sum && start < i) { 
                 curr_sum -= chocolates[start]; 
                 start++; 
             } 
   
             // Update max_sum if it becomes 
             // greater than curr_sum 
             max_sum = Math.max(max_sum, curr_sum); 
   
             // Add elements to curr_sum 
             curr_sum += chocolates[i]; 
         } 
   
    }
}