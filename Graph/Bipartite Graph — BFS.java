boolean isBipartite(int V, List<List<Integer>> adj) {

    int[] color = new int[V];
    Arrays.fill(color, -1);

    for (int start = 0; start < V; start++) {

        if (color[start] != -1)
            continue;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 0;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int neighbour : adj.get(node)) {

                if (color[neighbour] == -1) {

                    color[neighbour] = 1 - color[node];
                    q.offer(neighbour);

                } else if (color[neighbour] == color[node]) {

                    return false;
                }
            }
        }
    }

    return true;
}
