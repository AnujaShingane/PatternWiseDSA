class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    dfs(i,j,n,m,vis,grid);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void dfs(int i,int j,int n , int m,boolean[][] vis,char[][] grid){
        if(i<0 || i>=n || j<0 || j>=m || vis[i][j] || grid[i][j]=='0')return;

        vis[i][j]=true;

        dfs(i+1,j,n,m,vis,grid);
        dfs(i-1,j,n,m,vis,grid);
        dfs(i,j+1,n,m,vis,grid);
        dfs(i,j-1,n,m,vis,grid);
    }
}
