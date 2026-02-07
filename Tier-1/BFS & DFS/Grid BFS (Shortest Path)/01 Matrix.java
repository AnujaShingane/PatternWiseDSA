/*
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two cells sharing a common edge is 1.


Example 1:

Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
*/


class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] ans = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j]==0){
                    ans[i][j]=0;
                    q.add(new int[]{i,j,0});
                    vis[i][j]=true;
                }
            }
        }

        int[][] dir = {{0,-1},{-1,0},{0,1},{1,0}};

        while(!q.isEmpty()){
            int[] arr = q.poll();
            int r = arr[0];
            int c = arr[1];
            int dist = arr[2];

            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr<0 || nc<0 || nr>=n || nc>=m || vis[nr][nc])continue;

                vis[nr][nc]=true;
                ans[nr][nc]=dist+1;
                q.add(new int[]{nr,nc,dist+1});
            }
        }

        return ans;
    }
}
