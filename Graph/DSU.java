import java.util.*;

class DisjointSet {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }

        int ulp = findUPar(parent.get(node));

        // Path compression
        parent.set(node, ulp);

        return parent.get(node);
    }

    public void unionByRank(int u, int v) {

        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        // Already in the same component
        if (ulp_u == ulp_v) {
            return;
        }

        // Attach smaller rank tree under larger rank tree
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        }
        else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        }
        else {
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
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
