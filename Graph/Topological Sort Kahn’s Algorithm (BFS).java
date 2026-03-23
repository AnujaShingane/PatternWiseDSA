For DAG only

    Use : indegree arr + Queue 

    1. Make indegree arr and store indegrees of all nodes
    2. nodes with indegree 0, push 'em into the queue
    3. while !q.empty -> poll node add it to res
    4. traverse of all neighbours of that node reduce indegrees for those neighbour each time 
    5. each time when indegree becomes 0 of nei. offer it to the queue

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
