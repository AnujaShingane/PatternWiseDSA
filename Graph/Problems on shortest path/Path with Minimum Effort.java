class Pair{
    int row;
    int col;
    int effort;

    Pair(int row, int col, int effort){
        this.row = row;
        this.col = col;
        this.effort = effort;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
    
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.effort-b.effort
        );
 
        int[][] dist = new int[n][m];
        for(int[] arr : dist){
            Arrays.fill(arr,(int)(1e9));
        }
        dist[0][0]=0;

        pq.offer(new Pair(0,0,0));

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int r = p.row;
            int c = p.col;
            int ef = p.effort;

            if(r==n-1 && c==m-1)return ef;

            for(int i = 0 ; i < 4 ; i++){
                int nr = r + dr[i];
                int nc = c+dc[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    int newEffort = Math.max(ef,Math.abs(heights[r][c]-heights[nr][nc]));
                    if(newEffort < dist[nr][nc]){
                        dist[nr][nc]=newEffort;
                        pq.add(new Pair(nr,nc,newEffort));
                    }
                }
            }
        }

        return -1;
    }
}
