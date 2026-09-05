import java.util.*;

class DisjointSet {

    int[] size;
    int[] parent;

    public DisjointSet(int n) {

        size = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            size[i] = 1;
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

    public void unionBySize(int u, int v) {

        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) {
            return;
        }

        if (size[ulp_u] < size[ulp_v]) {

            parent[ulp_u] = ulp_v;
            size[ulp_v] = size[ulp_v] + size[ulp_u];

        } else {

            parent[ulp_v] = ulp_u;
            size[ulp_u] = size[ulp_u] + size[ulp_v];
        }
    }
}

class Main {

    public static void main(String[] args) {

        DisjointSet ds = new DisjointSet(8);

        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);

        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);

        ds.unionBySize(5, 6);

        // If 3 and 7 are in the same component
        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

        ds.unionBySize(3, 7);

        if (ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }
}
