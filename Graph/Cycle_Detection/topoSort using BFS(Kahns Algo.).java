class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        int n = edges.length;
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[V];
        Arrays.fill(indegree,0);
        for(int i = 0 ; i < n ; i++){
            indegree[edges[i][1]]++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = adjecencyList(V,edges);
        
        for(int i = 0 ; i < V ; i++){
            if(indegree[i]==0)q.add(i);
        }
        
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            
            for(int ele : adj.get(node)){
                indegree[ele]--;
                if(indegree[ele]==0)q.add(ele);
            }
        }
        
        return ans;
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
