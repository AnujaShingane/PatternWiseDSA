/*
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
*/


class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]==1)ans = Math.max(ans,dfs(grid,i,j));
            }
        }

        return ans;
    }

    public int dfs(int[][] grid,int r,int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length){
            return 0;
        }

        if(grid[r][c]==0 || grid[r][c]==-1){
            return 0;
        }

        grid[r][c]=-1;

        return 1+dfs(grid,r+1,c)+dfs(grid,r-1,c)+dfs(grid,r,c+1)+dfs(grid,r,c-1);
    }
}
