public int[][] multiSourceBFS(int[][] grid) {
    int n = grid.length, m = grid[0].length;
    Queue<int[]> q = new LinkedList<>();
    int[][] dist = new int[n][m];

    for (int i = 0; i < n; i++) {
        Arrays.fill(dist[i], -1);
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 1) {
                q.offer(new int[]{i, j});
                dist[i][j] = 0;
            }
        }
    }

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    while (!q.isEmpty()) {
        int[] curr = q.poll();

        for (int[] d : dirs) {
            int ni = curr[0] + d[0];
            int nj = curr[1] + d[1];

            if (ni>=0 && nj>=0 && ni<n && nj<m && dist[ni][nj]==-1) {
                dist[ni][nj] = dist[curr[0]][curr[1]] + 1;
                q.offer(new int[]{ni,nj});
            }
        }
    }
    return dist;
}
