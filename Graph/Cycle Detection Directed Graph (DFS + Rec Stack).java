Use : vis + pathVis
    1. dfs overall
    2. mark vis pathVis of node true 
    3. for each nei of node if not vis dfs if vis and pathVis return true
    4. while backtracking mark pathVis as false while returning
    
public boolean dfsDirected(int node, boolean[] vis, boolean[] pathVis, List<List<Integer>> adj) {
    vis[node] = true;
    pathVis[node] = true;

    for (int nei : adj.get(node)) {
        if (!vis[nei]) {
            if (dfsDirected(nei, vis, pathVis, adj)) return true;
        } else if (vis[nei] && pathVis[nei]) {
            return true;
        }
    }

    pathVis[node] = false;
    return false;
}
