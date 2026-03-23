For DAG only
Use : Stack + dfs + backtracking
    
public void topoDFS(int node, boolean[] vis, Stack<Integer> st, List<List<Integer>> adj) {
    vis[node] = true;

    for (int nei : adj.get(node)) {
        if (!vis[nei]) topoDFS(nei, vis, st, adj);
    }

    st.push(node); // backtracking
}
