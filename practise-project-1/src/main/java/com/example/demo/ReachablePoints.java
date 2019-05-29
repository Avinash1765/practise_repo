package com.example.demo;
import java.io.*;
import java.util.*;


public class ReachablePoints {
	static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String S = br.readLine();
            int Q = Integer.parseInt(br.readLine().trim());
            String[] arr_x = br.readLine().split(" ");
            int[] x = new int[Q];
            for(int i_x=0; i_x<arr_x.length; i_x++)
            {
            	x[i_x] = Integer.parseInt(arr_x[i_x]);
            }
            String[] arr_y = br.readLine().split(" ");
            int[] y = new int[Q];
            for(int i_y=0; i_y<arr_y.length; i_y++)
            {
            	y[i_y] = Integer.parseInt(arr_y[i_y]);
            }

            int out_ = solve(y, x,Q, S);
            System.out.println(out_);
            System.out.println("");
         }

         wr.close();
         br.close();
    }
    static int solve(int[] y, int[] x,int Q, String S){
            int n=S.length();
            boolean visited[]=new boolean[Q];
            for(int i=0;i<n;i++){
                for(int j=i;j<n;j++){
                    String str= S.substring(i, j+1);
                    ifReachable(str,x,y,Q,visited);
                }
            }
            for(int i=0;i<Q;i++){
            if(x[i]==0 && y[i]==0 && !visited[i]) {
				count++;
			}
            }
            return count;
    }
	private static void ifReachable(String str, int[] x, int[] y, int q,boolean visisted[]) {
		int currentX=0,currentY=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='U')
				currentY+=1;
			else if(str.charAt(i)=='D')
				currentY-=1;
			else if(str.charAt(i)=='R')
				currentX+=1;
			else
				currentX-=1;
			if(destination(x,y,visisted,q,currentX,currentY))
				count++;
		}
	}
	private static boolean destination(int[] x, int[] y, boolean[] visisted, int q, int currentX, int currentY) {
		for(int i=0;i<q;i++) {
			if(currentX==x[i] && currentY==y[i] && !visisted[i]) {
				visisted[i]=true;
				return true;
			}
		}
		return false;
	}
}