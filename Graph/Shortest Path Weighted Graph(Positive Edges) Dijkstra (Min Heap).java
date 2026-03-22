class Pair {
    int node, dist;
    Pair(int n, int d) {
        node = n;
        dist = d;
    }
}

public int[] dijkstra(int n, List<List<Pair>> adj, int src) {
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
    pq.offer(new Pair(src, 0));

    while (!pq.isEmpty()) {
        Pair curr = pq.poll();
        int node = curr.node;

        for (Pair nei : adj.get(node)) {
            if (dist[node] + nei.dist < dist[nei.node]) {
                dist[nei.node] = dist[node] + nei.dist;
                pq.offer(new Pair(nei.node, dist[nei.node]));
            }
        }
    }
    return dist;
}
