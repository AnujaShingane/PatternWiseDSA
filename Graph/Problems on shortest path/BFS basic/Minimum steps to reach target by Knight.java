class Pair{
    int[] pos;
    int wt;
    
    Pair(int[] pos, int wt){
        this.pos = pos;
        this.wt=wt;
    }
}

class Solution {
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(knightPos,0));
        boolean[][] vis = new boolean[n+1][n+1];
        vis[knightPos[0]][knightPos[1]]=true;
        int[][] dist = new int[n+1][n+1];
        for(int[] arr : dist){
            Arrays.fill(arr,(int)(1e9));
        }
        dist[knightPos[0]][knightPos[1]]=0;
        
        int dr[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int dc[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.pos[0];
            int c = p.pos[1];
            int wt = p.wt;
            
            for(int i = 0 ; i < 8 ; i++){
                int nr = r+dr[i];
                int nc = c+dc[i];
                int nwt = wt+1;
                
                if(nr<0 || nr>=n+1 || nc<0 || nc>=n+1 || vis[nr][nc])continue;
                
                vis[nr][nc]=true;
                if(nwt<dist[nr][nc]){
                    dist[nr][nc]=nwt;
                    q.offer(new Pair(new int[]{nr,nc},nwt));
                }
            }
        }
        
        return dist[targetPos[0]][targetPos[1]];
    }
}
