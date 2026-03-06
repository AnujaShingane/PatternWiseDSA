vis, Pair(node,parent)

class Pair{
    int node;
    int parent;
    
    Pair(int node,int parent){
        this.node = node;
        this.parent = parent;
    }
}

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = adj(V,edges);
        boolean[] vis = new boolean[V];
        
        for(int i = 0 ; i < V ; i++){
            if(!vis[i]){
                if(bfs(i,adj,vis))return true;
            }
        }
        
        return false;
    }
    
    public boolean bfs(int i,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        Queue<Pair> q = new LinkedList<>();
        boolean cycle = false;
        q.offer(new Pair(i,-1));
        vis[i]=true;
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            int parent = p.parent;
            
            for(int ele : adj.get(node)){
                if(vis[ele] && ele != parent)cycle=true;
                
                if(!vis[ele]){
                    vis[ele]=true;
                    q.add(new Pair(ele,node));
                }
            }
        }
        
        return cycle;
    }
    
    
    public ArrayList<ArrayList<Integer>> adj(int V , int[][] edges){
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
