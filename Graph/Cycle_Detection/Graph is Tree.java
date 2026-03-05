class Solution {
    
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        if(m!=n-1)return false;
        boolean[] vis = new boolean[n];
        ArrayList<ArrayList<Integer>> adj = adjecencyList(n,edges);
        
        if(dfs(0,-1,adj,vis))return false;
        
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
       vis[node] = true;
       
       for(int ele : adj.get(node)){
           if(!vis[ele]){
               if(dfs(ele,node,adj,vis)) return true;
           }
           else if(ele != parent){
               return true;
           }
       }
       
       return false;
    }
    
    public ArrayList<ArrayList<Integer>> adjecencyList(int V,
                        ArrayList<ArrayList<Integer>> edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(ArrayList<Integer> list : edges){
            int u = list.get(0);
            int v = list.get(1);
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        return adj;
    }
}
