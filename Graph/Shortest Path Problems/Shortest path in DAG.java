class Pair{
    int node;
    int wt;
    
    Pair(int node,int wt){
        this.node=node;
        this.wt=wt;
    }
}

class Solution {
    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = adjList(V,E,edges);
        Stack<Integer> st = topoSort(adj);
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        
        //relax edges and store distance in dist arr till st does not become empty
        while(!st.isEmpty()){
            int n = st.pop();
            int d = dist[n];
            if(d==Integer.MAX_VALUE)continue;
            
            for(Pair p : adj.get(n)){
                int ele = p.node;
                int dis = p.wt;
                
                int newDist = d+dis;
                dist[ele] = Math.min(dist[ele],newDist);
            }
        }
        
        for(int i = 0; i < V; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        
        return dist;
    }
    
    public Stack<Integer> topoSort(ArrayList<ArrayList<Pair>> adj){
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[adj.size()];
        int n = adj.size();
        
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                dfs(i,adj,st,vis);
            }
        }
        
        return st;
    }
    
    public void dfs(int node,ArrayList<ArrayList<Pair>> adj,Stack<Integer> st,
                    boolean[] vis){
        vis[node] = true;
        
        for(Pair p : adj.get(node)){
            int ele = p.node;
            if(!vis[ele]){
                dfs(ele,adj,st,vis);
            }
        }
        
        st.push(node);
    }
    
    public ArrayList<ArrayList<Pair>> adjList(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < E ; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
        }
        
        return adj;
    }
}
