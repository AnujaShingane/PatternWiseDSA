class Edge {
    int u, v, wt;

    Edge(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
}

int kruskal(int V, int[][] edges) {

    Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

    DisjointSet ds = new DisjointSet(V);

    int mstWeight = 0;
    int edgesUsed = 0;

    for (int[] edge : edges) {
        int u = edge[0];
        int v = edge[1];
        int wt = edge[2];

        if (ds.findUPar(u) != ds.findUPar(v)) {
            mstWeight += wt;
            edgesUsed++;
            ds.unionBySize(u, v);
        }

        if (edgesUsed == V - 1)
            break;
    }

    return mstWeight;
}
