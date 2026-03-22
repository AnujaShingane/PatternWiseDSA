public boolean hasCycleKahn(int n, List<List<Integer>> adj) {
    int[] indegree = new int[n];

    for (int i = 0; i < n; i++) {
        for (int nei : adj.get(i)) {
            indegree[nei]++;
        }
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < n; i++) {
        if (indegree[i] == 0) q.offer(i);
    }

    int count = 0;
    while (!q.isEmpty()) {
        int node = q.poll();
        count++;

        for (int nei : adj.get(node)) {
            if (--indegree[nei] == 0) {
                q.offer(nei);
            }
        }
    }

    return count != n; // cycle if not all processed
}
