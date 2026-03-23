Use : indegree + queue
    (Same as topo sort in directed using kahn's algo)
    imp -> works on DAG -> Acyclic 
      condn -> if(count == n) -> Acyclic (No cycle) else cycle detected

public boolean hasCycleKahn(int n, List<List<Integer>> adj) {
    int[] indegree = new int[n];

    for (int i = 0; i < n; i++) {
        for (int nei : adj.get(i)) {
            indegree[nei]++;
        }
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < n; i++) {
        if (indegree[i] == 0) q.offer(i);
    }

    int count = 0;
    while (!q.isEmpty()) {
        int node = q.poll();
        count++;

        for (int nei : adj.get(node)) {
            indegree[nei] -= 1;
            if (indegree[nei] == 0) {
                q.offer(nei);
            }
        }
    }

    return count != n; // cycle if not all processed
}
