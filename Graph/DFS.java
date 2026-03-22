public void dfs(int node, boolean[] vis, List<List<Integer>> adj) {
    vis[node] = true;

    for (int nei : adj.get(node)) {
        if (!vis[nei]) {
            dfs(nei, vis, adj);
        }
    }
}
