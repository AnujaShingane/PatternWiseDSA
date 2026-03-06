class Pair{
    int node;
    int wt;
    
    Pair(int node,int wt){
        this.node = node;
        this.wt = wt;
    }
}

class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Integer>> adj = adjecencyList(V,edges);
        Queue<Pair> q = new LinkedList<>();
        int[] dist = new int[V];
        for(int i = 0 ; i < V ; i++){
            dist[i] = (int)(1e9);
        }
        
        q.add(new Pair(src,0));
        dist[src]=0;
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int n = p.node;
            int dis = p.wt;
            
            for(int ele : adj.get(n)){
                int finalDist = dis+1;
                if(dist[ele]>finalDist){
                    dist[ele] = finalDist;
                    q.add(new Pair(ele,finalDist));
                }
            }
        }
        
        for(int i = 0 ; i < V ; i++){
            if(dist[i]==(int)(1e9)){
                dist[i]=-1;
            }
        }
        
        return dist;
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
