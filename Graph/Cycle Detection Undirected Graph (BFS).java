Use : Queue + vis
    imp -> the nei node to which we're approaching if it is already vis and also not a parent 
           i.e the node that we just cam from then there exists a cycle

    1. while !q.isEmpty -> travel to each nei if not vis offer it to queue while marking vis true
    2. if vis and !parent -> return true

public boolean bfsCycle(int src, List<List<Integer>> adj, boolean[] vis) {
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{src, -1});
    vis[src] = true;

    while (!q.isEmpty()) {
        int[] curr = q.poll();
        int node = curr[0], parent = curr[1];

        for (int nei : adj.get(node)) {
            if (!vis[nei]) {
                vis[nei] = true;
                q.offer(new int[]{nei, node});
            } else if (nei != parent) {
                return true;
            }
        }
    }
    return false;
}
