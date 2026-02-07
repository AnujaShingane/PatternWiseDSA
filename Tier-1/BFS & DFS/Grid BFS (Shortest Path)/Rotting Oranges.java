/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
*/


class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] ans = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                }
                ans[i][j]=grid[i][j];
            }
        }

        int[][] dir = {{0,-1},{-1,0},{0,1},{1,0}};

        int min = 0;
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int r = arr[0];
            int c = arr[1];
            int time = arr[2];

            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr<0 || nc<0 || nr>=n || nc>=m || ans[nr][nc]==0 || ans[nr][nc]==2){
                    continue;
                }

                ans[nr][nc] = 2;
                q.add(new int[]{nr,nc,time+1});
                min = Math.max(min,time+1);
            }
        }
        
        for(int[] array : ans){
            for(int ele : array){
                if(ele==1)return -1;
            }
        }

        return min;
    }
}
