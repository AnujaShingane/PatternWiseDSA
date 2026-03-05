class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int V = edges.length;
        ArrayList<ArrayList<Integer>> adj = adjacencyList(V, edges);
        List<Integer> list = findCycle(V, adj);

        for(int i = V-1 ; i >= 0 ; i--){
            int u = edges[i][0];
            int v = edges[i][1];

            if(list.contains(u) && list.contains(v)){
                return new int[]{u,v};
            }
        }

        return new int[]{};
    }

    public List<Integer> findCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        List<Integer> cycle = new ArrayList<>();
        boolean[] vis = new boolean[V+1];
        int[] parent = new int[V+1];
        Arrays.fill(parent, -1);

        for(int i = 1; i <= V; i++){
            if(!vis[i]){
                if(dfs(i, -1, vis, parent, adj,cycle)){
                    return cycle;
                }
            }
        }

        return new ArrayList<>();
    }

    public boolean dfs(int node, int par, boolean[] vis, int[] parent,
                       ArrayList<ArrayList<Integer>> adj,List<Integer> cycle){
        vis[node] = true;
        for(int ele : adj.get(node)){
            if(!vis[ele]){
                parent[ele] = node;
                if(dfs(ele, node, vis, parent, adj,cycle))return true;
            }
            else if(ele != par){ //cycle detected
                cycle.add(ele);
                int cur = node;

                while(cur != ele){
                    cycle.add(cur);
                    cur = parent[cur];
                }
                return true;
            }
        }

        return false;
    }

    public ArrayList<ArrayList<Integer>> adjacencyList(int V,int[][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i <= V ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] arr : edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        return adj;
    }
}
