boolean dfs(int node, int col,
            int[] color,
            List<List<Integer>> adj) {

    color[node] = col;

    for (int neighbour : adj.get(node)) {

        if (color[neighbour] == -1) {

            if (!dfs(neighbour, 1 - col, color, adj))
                return false;

        } else if (color[neighbour] == color[node]) {

            return false;
        }
    }

    return true;
}
