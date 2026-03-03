class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0 ; i < m ; i++){
            if(grid[0][i]==1)dfs(0,i,n,m,grid);
        }

        for(int j = 0 ; j < n ; j++){
            if(grid[j][m-1]==1)dfs(j,m-1,n,m,grid);
        }

        for(int k = 0 ; k < m ; k++){
            if(grid[n-1][k]==1)dfs(n-1,k,n,m,grid);
        }

        for(int l = 0 ; l < n ; l++){
            if(grid[l][0]==1)dfs(l,0,n,m,grid);
        }

        int cnt = 0;
        for(int[] arr : grid){
            for(int num : arr){
                if(num==1)cnt++;
            }
        }

        return cnt;
    }

    public void dfs(int r,int c,int n,int m,int[][] grid) {
        if(r<0 || r>=n || c<0 || c>=m || grid[r][c]==0)return;

        grid[r][c] = 0;

        dfs(r+1,c,n,m,grid);
        dfs(r-1,c,n,m,grid);
        dfs(r,c+1,n,m,grid);
        dfs(r,c-1,n,m,grid);
    }
}
