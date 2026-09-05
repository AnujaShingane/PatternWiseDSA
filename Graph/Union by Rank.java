import java.util.*;

class DisjointSet {

    int[] rank;
    int[] parent;

    public DisjointSet(int n) {

        rank = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i] = 0;
            parent[i] = i;
        }
    }

    public int findUPar(int node) {

        if (node == parent[node]) {
            return node;
        }

        // Path compression
        return parent[node] = findUPar(parent[node]);
    }

    public void unionByRank(int u, int v) {

        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        // Already in the same component
        if (ulp_u == ulp_v) {
            return;
        }

        // Attach smaller rank tree under larger rank tree
        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        }
        else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
        }
        else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }
}

class Main {

    public static void main(String[] args) {

        DisjointSet ds = new DisjointSet(8);

        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);

        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);

        ds.unionByRank(5, 6);

        // Check whether 3 and 7 belong to the same component
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        }
        else {
            System.out.println("Not Same");
        }

        // Now connect the two components
        ds.unionByRank(3, 7);

        // Check again
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        }
        else {
            System.out.println("Not Same");
        }
    }
}
