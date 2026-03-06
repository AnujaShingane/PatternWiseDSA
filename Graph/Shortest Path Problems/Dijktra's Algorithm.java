class Pair{
    int dist;
    int node;
    
    Pair(int dist, int node){
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.dist-b.dist
        );
        
        int[] dist = new int[V];
        for(int i = 0 ; i < V ; i++){
            dist[i]=(int)(1e9);
        }
        dist[src]=0;
        pq.add(new Pair(0,src));
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] arr : edges){
            int u = arr[0];
            int v = arr[1];
            int wt = arr[2];
            
            adj.get(u).add(new Pair(wt,v));
            adj.get(v).add(new Pair(wt,u));
        }
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int dis = p.dist;
            int n = p.node;
            
            for(Pair ele : adj.get(n)){
                int adjNodeDist = ele.dist;
                int adjNode = ele.node;
                
                int finalDist = adjNodeDist + dis;
                if(finalDist<dist[adjNode]){
                    dist[adjNode]=finalDist;
                    pq.add(new Pair(finalDist,adjNode));
                }
            }
        }
        
        for(int i = 0 ; i < V ; i++){
            if(dist[i]==(int)(1e9)){
                dist[i] = -1;
            }
        }
        
        return dist;
    }
}
