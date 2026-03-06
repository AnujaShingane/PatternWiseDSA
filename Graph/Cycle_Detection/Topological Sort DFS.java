class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = adjecencyList(V,edges);
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0 ; i < V ; i++){
            if(!vis[i]){
                dfs(i,vis,adj,st);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        
        return ans;
    }
    
    public void dfs(int node,boolean[] vis,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        vis[node]=true;
        
        for(int ele : adj.get(node)){
            if(!vis[ele]){
                dfs(ele,vis,adj,st);
            }
        }
        
        st.push(node);
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
