/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
*/


class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    dfs(grid,i,j);
                }
            }
        }

        return cnt;
    }

    public void dfs(char[][] grid, int r , int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length){
            return;
        }

        if(grid[r][c]=='0' || grid[r][c]=='2'){
            return;
        }

        grid[r][c]='2';

        dfs(grid,r+1,c);
        dfs(grid,r,c+1);
        dfs(grid,r-1,c);
        dfs(grid,r,c-1);
    }
}
