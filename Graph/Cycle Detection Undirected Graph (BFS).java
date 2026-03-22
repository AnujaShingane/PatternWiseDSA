public boolean bfsCycle(int src, List<List<Integer>> adj, boolean[] vis) {
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{src, -1});
    vis[src] = true;

    while (!q.isEmpty()) {
        int[] curr = q.poll();
        int node = curr[0], parent = curr[1];

        for (int nei : adj.get(node)) {
            if (!vis[nei]) {
                vis[nei] = true;
                q.offer(new int[]{nei, node});
            } else if (nei != parent) {
                return true;
            }
        }
    }
    return false;
}
