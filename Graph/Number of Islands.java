public int numIslands(char[][] grid) {
    int n = grid.length, m = grid[0].length;
    int count = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == '1') {
                count++;
                dfsIsland(grid, i, j);
            }
        }
    }
    return count;
}

private void dfsIsland(char[][] g, int r, int c) {
    if (r<0 || c<0 || r>=g.length || c>=g[0].length || g[r][c]=='0') return;

    g[r][c] = '0';

    dfsIsland(g, r+1, c);
    dfsIsland(g, r-1, c);
    dfsIsland(g, r, c+1);
    dfsIsland(g, r, c-1);
}
