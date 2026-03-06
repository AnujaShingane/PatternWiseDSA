class Pair{
    int node;
    int wt;
    
    Pair(int node,int wt){
        this.node = node;
        this.wt=wt;
    }
}

class Solution {
    public int[] shortestPath(int V, int E, int[][] edges) {
        int n1 = edges.length;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < n1 ; i++){
            int s = edges[i][0];
            int e = edges[i][1];
            int wt = edges[i][2];
            adj.get(s).add(new Pair(e,wt));
        }
        
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        for(int i = 0 ; i < V ; i++){
            if(!vis[i]){
                dfs(i,st,vis,adj);
            }
        }
        
        int[] dist = new int[V];
        Arrays.fill(dist,(int)(1e9));
        dist[0]=0;
        
        while(!st.isEmpty()){
            int node = st.pop();
            int dis = dist[node];
            
            for(Pair p : adj.get(node)){
                int n = p.node;
                int d = p.wt;
                
                int finalDist = dis + d;
                if(finalDist < dist[n]){
                    dist[n] = finalDist;
                }
            }
        }
        
        
        for(int i = 0 ; i < dist.length ; i++){
            if(dist[i]==(int)(1e9)){
                dist[i]=-1;
            }
        }
        
        return dist;
    }
    
    public void dfs(int node,Stack<Integer> st,boolean[] vis,ArrayList<ArrayList<Pair>> adj){
        vis[node]=true;
        
        for(Pair elePair : adj.get(node)){
            int ele = elePair.node;
            
            if(!vis[ele]){
                dfs(ele,st,vis,adj);
            }
        }
        
        st.push(node);
    }
}
