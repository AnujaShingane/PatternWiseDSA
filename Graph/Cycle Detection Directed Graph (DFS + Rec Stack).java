public boolean dfsDirected(int node, boolean[] vis, boolean[] pathVis, List<List<Integer>> adj) {
    vis[node] = true;
    pathVis[node] = true;

    for (int nei : adj.get(node)) {
        if (!vis[nei]) {
            if (dfsDirected(nei, vis, pathVis, adj)) return true;
        } else if (pathVis[nei]) {
            return true;
        }
    }

    pathVis[node] = false;
    return false;
}
