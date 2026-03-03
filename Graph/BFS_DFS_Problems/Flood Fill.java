class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] res = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                res[i][j] = image[i][j];
            }
        }

        dfs(sr,sc,n,m,image[sr][sc],color,res,vis);

        return res;
    }

    public void dfs(int sr,int sc,int n,int m,int startingColor,int color,int[][] res,boolean[][] vis) {
        if(sr<0 || sr>=n || sc<0 || sc>=m || vis[sr][sc] || res[sr][sc]!=startingColor)return;
        vis[sr][sc]=true;
        res[sr][sc]=color;

        dfs(sr+1,sc,n,m,startingColor,color,res,vis);
        dfs(sr-1,sc,n,m,startingColor,color,res,vis);
        dfs(sr,sc+1,n,m,startingColor,color,res,vis);
        dfs(sr,sc-1,n,m,startingColor,color,res,vis);
    }
}
