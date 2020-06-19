package com.example.demo;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
    	Map m=new HashMap<>();
    	m.get
            for(int i=0;i<q.length;i++){
                if(q[i]>i+3){
                    System.out.println("Too chaotic");
                    return;
                }
            }
            int count=0;
        for(int i=0;i<q.length;i++){
            if(q[i]!=i+1){
                int diff=q[i]-(i+1);
                count+=diff;
                i+=diff;
            }
        }
        System.out.println(count);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}

