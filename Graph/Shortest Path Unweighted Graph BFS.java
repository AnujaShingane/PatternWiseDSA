public int[] bfsShortestPath(int n, List<List<Integer>> adj, int src) {
    int[] dist = new int[n];
    Arrays.fill(dist, -1);

    Queue<Integer> q = new LinkedList<>();
    q.offer(src);
    dist[src] = 0;

    while (!q.isEmpty()) {
        int node = q.poll();

        for (int nei : adj.get(node)) {
            if (dist[nei] == -1) {
                dist[nei] = dist[node] + 1;
                q.offer(nei);
            }
        }
    }
    return dist;
}
