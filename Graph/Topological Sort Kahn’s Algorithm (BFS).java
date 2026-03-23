For DAG only

    1. Make indegree arr and store all indegrees of all nodes
    2. nodes with indegree 0, push 'em into the queue
    3. 

public List<Integer> topoSort(int n, List<List<Integer>> adj) {
    int[] indegree = new int[n];
    for (int i = 0; i < n; i++) {
        for (int nei : adj.get(i)) indegree[nei]++;
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < n; i++) {
        if (indegree[i] == 0) q.offer(i);
    }

    List<Integer> res = new ArrayList<>();

    while (!q.isEmpty()) {
        int node = q.poll();
        res.add(node);

        for (int nei : adj.get(node)) {
            indegree[nei] -= 1;
            if (indegree[nei] == 0) q.offer(nei);
        }
    }

    return res;
}
