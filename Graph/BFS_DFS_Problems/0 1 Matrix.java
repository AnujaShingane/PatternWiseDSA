class Pair{
    int i;
    int j;
    int dist;

    Pair(int i,int j,int dist){
        this.i = i;
        this.j = j;
        this.dist = dist;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        int[][] ans = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    ans[i][j]=0;
                    vis[i][j]=true;
                }
            }
        }

        int[] di = {-1,0,1,0};
        int[] dj = {0,1,0,-1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int i = p.i;
            int j = p.j;
            int dist = p.dist;

            for(int z = 0 ; z < 4; z++){
                int newi = i+di[z];
                int newj = j+dj[z];

                if(newi>=0 && newi<n && newj>=0 && newj<m && !vis[newi][newj] && mat[newi][newj]==1){
                    vis[newi][newj]=true;
                    q.add(new Pair(newi,newj,dist+1));
                    ans[newi][newj] = dist+1;
                }
            }
        }

        return ans;
    }
}
