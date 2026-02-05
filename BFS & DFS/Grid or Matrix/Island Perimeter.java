/*
You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example 1:


Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.
Example 2:

Input: grid = [[1]]
Output: 4
Example 3:

Input: grid = [[1,0]]
Output: 4
*/


class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]==1)return dfs(grid,i,j);
            }
        }

        return 0;
    }

    public int dfs(int[][] grid,int r,int c){
        //reached in water(not 0 but out of grid) - add 1 for water boundary
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length){
            return 1;
        }

        //inside grid reached water add 1
        if(grid[r][c]==0)return 1;

        //if vis don't add anything to perimeter
        if(grid[r][c]==-1){
            return 0;
        }

        grid[r][c] = -1;

        return dfs(grid,r+1,c)+dfs(grid,r-1,c)+dfs(grid,r,c+1)+dfs(grid,r,c-1);
    }
}
