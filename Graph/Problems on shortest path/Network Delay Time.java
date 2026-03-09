class Pair{
    int node;
    int dist;

    Pair(int node,int dist){
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            dist[i] = (int)(1e9);
        }
        dist[0] = 0;
        dist[k] = 0;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr : times){
            int u = arr[0];
            int v = arr[1];
            int wt = arr[2];

            adj.get(u).add(new Pair(v,wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.dist-b.dist
        );

        pq.add(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int n1 = p.node;
            int dis = p.dist;

            for(Pair adjEle : adj.get(n1)){
                int adjNode = adjEle.node;
                int adjDist = adjEle.dist;

                int finalDist = adjDist + dis;
                if(finalDist < dist[adjNode]){
                    dist[adjNode]=finalDist;
                    pq.add(new Pair(adjNode,finalDist));
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int num : dist){
            if(num == (int)(1e9))return -1;
            max = Math.max(max,num);
        }

        return max;
    }
}
