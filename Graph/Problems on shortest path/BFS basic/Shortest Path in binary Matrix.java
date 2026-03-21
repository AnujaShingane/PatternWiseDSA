class Pair{
    int[] arr;
    int wt;
    
    Pair(int[] arr, int wt){
        this.arr = arr;
        this.wt=wt;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1) return -1;
        if(grid[n-1][n-1]==1)return -1;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        vis[0][0]=true;
        int[][] dist = new int[n][n];
        for(int[] arr : dist){
            Arrays.fill(arr,(int)(1e9));
        }
        dist[0][0]=1;
        q.offer(new Pair(new int[]{0,0},1));

        int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.arr[0];
            int c = p.arr[1];
            int w = p.wt;

            for(int i = 0 ; i < 8 ; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                int newWt = w+1;

                if(nr<0 || nr>=n || nc<0 || nc>=n || vis[nr][nc] || grid[nr][nc]==1)continue;

                if(dist[nr][nc]>newWt){
                    vis[nr][nc]=true;
                    dist[nr][nc]=newWt;
                    q.offer(new Pair(new int[]{nr,nc},newWt));
                }
            }
        }

        if(dist[n-1][n-1]==(int)(1e9)){
            return -1;
        }
        return dist[n-1][n-1];
    }
}
