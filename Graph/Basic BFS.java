public void bfs(int start, List<List<Integer>> adj, int n) {
    boolean[] vis = new boolean[n];
    Queue<Integer> q = new LinkedList<>();

    q.offer(start);
    vis[start] = true;

    while (!q.isEmpty()) {
        int node = q.poll();
        System.out.print(node + " "); // process node

        for (int nei : adj.get(node)) {
            if (!vis[nei]) {
                vis[nei] = true;
                q.offer(nei);
            }
        }
    }
}
