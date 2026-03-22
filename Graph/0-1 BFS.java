public int[] zeroOneBFS(int n, List<List<Pair>> adj, int src) {
    Deque<Integer> dq = new ArrayDeque<>();
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);

    dist[src] = 0;
    dq.offerFirst(src);

    while (!dq.isEmpty()) {
        int node = dq.pollFirst();

        for (Pair nei : adj.get(node)) {
            if (dist[node] + nei.dist < dist[nei.node]) {
                dist[nei.node] = dist[node] + nei.dist;

                if (nei.dist == 0)
                    dq.offerFirst(nei.node);
                else
                    dq.offerLast(nei.node);
            }
        }
    }
    return dist;
}
