public boolean dfsCycle(int node, int parent, boolean[] vis, List<List<Integer>> adj) {
    vis[node] = true;

    for (int nei : adj.get(node)) {
        if (!vis[nei]) {
            if (dfsCycle(nei, node, vis, adj)) return true;
        } else if (nei != parent) {
            return true;
        }
    }
    return false;
}
