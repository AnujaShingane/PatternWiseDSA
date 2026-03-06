vis,pathVis,f(node,parent)

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = adjecencyList(V,edges);
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        
        for(int i = 0 ; i < V ; i++){
            if(!vis[i]){
                if(dfs(i,-1,vis,pathVis,adj))return true;
            }
        }
        
        return false;
    }
    
    public boolean dfs(int node,int parent, boolean[] vis, boolean[] pathVis,ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        pathVis[node] = true;
        
        for(int ele : adj.get(node)){
            if(!vis[ele]){
                if(dfs(ele,node,vis,pathVis,adj))return true;
            }
            else if(vis[ele] && pathVis[ele]){
                return true;
            }
        }
        
        pathVis[node]=false;
        return false;
    }
    
    public ArrayList<ArrayList<Integer>> adjecencyList(int V,int[][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] arr : edges){
            adj.get(arr[0]).add(arr[1]);
        }
        
        return adj;
    }
}
