Input :
V = 5
edges = [
[0,1,2],
[0,2,4],
[1,2,1],
[1,3,7],
[2,4,3],
[3,4,1]
]
src = 0

Graph

0 --2--> 1
0 --4--> 2
1 --1--> 2
1 --7--> 3
2 --3--> 4
3 --1--> 4

Shortest distance from source 0

0 : 0
1 : 2
2 : 3
3 : 9
4 : 6

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
