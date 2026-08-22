//main driver
boolean[] vis = new boolean[n];
boolean[] pathVis = new boolean[n];

for (int i = 0; i < n; i++) {
    if (!vis[i]) {
        if (cycleDetection(i, vis, pathVis, adj)) {
            return true; // cycle exists
        }
    }
}

return false;

//logic
public boolean cycleDetection(int node, boolean[] vis, boolean[] pathVis, List<List<Integer>> adj) {
    vis[node] = true;
    pathVis[node] = true;

    for (int nei : adj.get(node)) {
        if (!vis[nei]) {
            if (cycleDetection(nei, vis, pathVis, adj)) {
                return true;
            }
        } else if (pathVis[nei]) {
            return true;
        }
    }

    pathVis[node] = false;
    return false;
}
