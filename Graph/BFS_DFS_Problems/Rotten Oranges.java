class Pair{
    int i;
    int j;

    Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        int min = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        if(fresh==0)return 0;

        int[] di = {-1,0,1,0};
        int[] dj = {0,1,0,-1};

        while(!q.isEmpty()){
            int size = q.size();
            boolean rotted = false;

            while(size--!=0){
                Pair p = q.poll();
                int i = p.i;
                int j = p.j;

                for(int z = 0 ; z < 4 ; z++){
                    int newi = i+di[z];
                    int newj = j+dj[z];

                    if(newi>=0 && newi<n && newj>=0 && newj<m && !vis[newi][newj] && grid[newi][newj]==1){
                        vis[newi][newj]=true;
                        grid[newi][newj]=2;
                        q.add(new Pair(newi,newj));
                        fresh--;
                        rotted=true;
                    }
                }
            }
            if(rotted)min++;
        }

        return (fresh==0) ? min : -1;
    }
}
