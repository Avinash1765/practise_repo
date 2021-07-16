package com.example.demo.leetcode;

public class Problem1219 {
	
	public static void main(String[] args) {
		Problem1219 obj= new Problem1219();
		
		int[][] grid= {{5}};
		
		System.out.println(obj.getMaximumGold(grid));
		
	}
	
	
  //  int maxGold[][];
    public int getMaximumGold(int[][] grid) {
        int result= Integer.MIN_VALUE;
        
        int r= grid.length;
        int c= grid[0].length;
        
     //   maxGold= new int[r][c];
        
        boolean visited[][]= new boolean[r][c];
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c; j++){
                result= Math.max(result, calc(grid, visited, i, j, r, c));
            }
        } 
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c; j++){
                System.out.print(maxGold[i][j]+" ");
            }
            
        } 
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c; j++){
                System.out.print(visited[i][j]+" ");
            }
            System.out.println();
        } 
        
        return result;     
    }
    
    public int calc(int[][] grid, boolean[][] visited, int x, int y, int r, int c){
        if(x<0 || y<0 || x>=r || y>=c || grid[x][y]==0 || visited[x][y])
            return 0;
        
//        if(maxGold[x][y]!=0)
//            return maxGold[x][y];
        
        visited[x][y]= true;
        
        int m= calc(grid, visited, x-1, y, r, c);
        int n= calc(grid, visited, x+1, y, r, c);
        int o= calc(grid, visited, x, y-1, r, c);
        int p= calc(grid, visited, x, y+1, r,c);
        
     //   maxGold[x][y]= Math.max(p,Math.max(o,Math.max(m,n))) + grid[x][y];
        
        visited[x][y]= false;
        
        return Math.max(p,Math.max(o,Math.max(m,n))) + grid[x][y];     
    }
}
