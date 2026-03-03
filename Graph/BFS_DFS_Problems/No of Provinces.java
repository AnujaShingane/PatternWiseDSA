class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj = adjecencyList(isConnected,adj);

        boolean[] vis = new boolean[n];
        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                cnt++;
                dfs(i,adj,vis);
            }
        }

        return cnt;
    }

    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        vis[node]=true;

        for(int ele : adj.get(node)){
            if(!vis[ele]){
                dfs(ele,adj,vis);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> adjecencyList(int[][] isConnected,ArrayList<ArrayList<Integer>> adj){
        int n = isConnected.length;
        int m = isConnected[0].length;

        for(int z = 0 ; z < n ; z++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(i!=j && isConnected[i][j]==1){
                    adj.get(i).add(j);
                }
            }
        }

        return adj;
    }
}
