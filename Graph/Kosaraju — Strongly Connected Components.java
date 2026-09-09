void dfs1(int node, boolean[] vis,
          List<List<Integer>> adj,
          Stack<Integer> st) {

    vis[node] = true;

    for (int next : adj.get(node)) {
        if (!vis[next])
            dfs1(next, vis, adj, st);
    }

    st.push(node);
}

void dfs2(int node, boolean[] vis,
          List<List<Integer>> rev) {

    vis[node] = true;

    for (int next : rev.get(node)) {
        if (!vis[next])
            dfs2(next, vis, rev);
    }
}

int kosaraju(int V, List<List<Integer>> adj) {

    boolean[] vis = new boolean[V];
    Stack<Integer> st = new Stack<>();

    // Step 1
    for (int i = 0; i < V; i++) {
        if (!vis[i])
            dfs1(i, vis, adj, st);
    }

    // Step 2: reverse graph
    List<List<Integer>> rev = new ArrayList<>();

    for (int i = 0; i < V; i++)
        rev.add(new ArrayList<>());

    for (int u = 0; u < V; u++) {
        for (int v : adj.get(u)) {
            rev.get(v).add(u);
        }
    }

    // Step 3
    Arrays.fill(vis, false);

    int scc = 0;

    while (!st.isEmpty()) {

        int node = st.pop();

        if (!vis[node]) {
            dfs2(node, vis, rev);
            scc++;
        }
    }

    return scc;
}
