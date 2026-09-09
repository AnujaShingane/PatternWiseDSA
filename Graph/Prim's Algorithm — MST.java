int prim(int V, List<List<int[]>> adj) {

    PriorityQueue<int[]> pq =
        new PriorityQueue<>((a, b) -> a[0] - b[0]);

    boolean[] visited = new boolean[V];

    pq.offer(new int[]{0, 0}); // {weight, node}

    int mstWeight = 0;

    while (!pq.isEmpty()) {

        int[] curr = pq.poll();

        int wt = curr[0];
        int node = curr[1];

        if (visited[node])
            continue;

        visited[node] = true;
        mstWeight += wt;

        for (int[] next : adj.get(node)) {

            int neighbour = next[0];
            int edgeWeight = next[1];

            if (!visited[neighbour]) {
                pq.offer(new int[]{edgeWeight, neighbour});
            }
        }
    }

    return mstWeight;
}
