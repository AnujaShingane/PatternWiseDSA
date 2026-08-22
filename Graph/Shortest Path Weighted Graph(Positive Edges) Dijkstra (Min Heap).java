Dijkstra (weighted + positive)
    Use : PriorityQueue + dist arr

        1. start with all 1e9 valued dist arr
        2. put src in pq
        3. while !q.empty relax the edges and update the distances

class Pair {
    int node;
    int dist;
    
    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

public int[] dijkstra(int n1, List<List<Pair>> adj, int src) {
    int[] dist = new int[n1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
    pq.offer(new Pair(src, 0));

    while (!pq.isEmpty()) {
        Pair curr = pq.poll();
        int node = curr.node;
        int d = curr.dist;

        if(d>dist[node])continue;

        //relaxation of edges
        for (Pair nei : adj.get(node)) {
            int n = nei.node;
            int dis = nei.dist;
            int newDist = dis+d;

            if(newDist<dist[n]){
                dist[n] = newDist;
                pq.offer(new Pair(n,newDist));
            }
        }
    }
    return dist;
}
