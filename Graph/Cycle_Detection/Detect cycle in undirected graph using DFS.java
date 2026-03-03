class Solution {
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = adjecencyList(V,edges);
        boolean[] vis = new boolean[V];
        
        for(int i = 0 ; i < V ; i++){
            if(!vis[i]){
                if(dfs(i,-1,vis,adj))return true;
            }
        }
        
        return false;
    }
    
    public boolean dfs(int node,int parent,boolean[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        
        for(int ele : adj.get(node)){
            if(!vis[ele]){
                if(dfs(ele,node,vis,adj))return true;
            }else{
                if(parent != ele)return true;
            }
        }
        
        return false;
    }
    
    public ArrayList<ArrayList<Integer>> adjecencyList(int V , int[][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] arr : edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        
        return adj;
    }
}
