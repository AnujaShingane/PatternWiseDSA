public int[] bellmanFord(int n, int[][] edges, int src) {
    int[] dist = new int[n];
    Arrays.fill(dist, (int)1e9);
    dist[src] = 0;

    for (int i = 0; i < n - 1; i++) {
        for (int[] e : edges) {
            int u = e[0], v = e[1], wt = e[2];
            if (dist[u] != 1e9 && dist[u] + wt < dist[v]) {
                dist[v] = dist[u] + wt;
            }
        }
    }

    // detect negative cycle
    for (int[] e : edges) {
        if (dist[e[0]] + e[2] < dist[e[1]]) {
            System.out.println("Negative cycle exists");
        }
    }

    return dist;
}
