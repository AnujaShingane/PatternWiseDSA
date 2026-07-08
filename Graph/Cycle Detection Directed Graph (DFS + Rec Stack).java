Use : vis + pathVis
    1. dfs overall
    2. mark vis pathVis of node true 
    3. for each nei of node if not vis dfs if vis and pathVis return true
    4. while backtracking mark pathVis as false while returning

public static void main(){
        List<List<Integer>> adj = adjList(prerequisites,numCourses); 
        boolean[] vis = new boolean[n]; 
        boolean[] pathvis = new boolean[n]; 
 
        for(int i = 0 ; i < n ; i++){ 
            if(!vis[i]){ 
                if(cycleDetection(i,vis,pathvis,adj))return false; 
            } 
        } 
 
        return true;
}

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
