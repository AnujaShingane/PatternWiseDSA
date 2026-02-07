/*
Given an undirected graph with V vertices and E edges, represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge between vertices u and v, determine whether the graph contains a cycle or not.

Note: The graph can have multiple component.

Examples:

Input: V = 4, E = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
Output: true
Explanation: 
 
1 -> 2 -> 0 -> 1 is a cycle.
Input: V = 4, E = 3, edges[][] = [[0, 1], [1, 2], [2, 3]]
Output: false
Explanation: 
 
No cycle in the graph.
*/


class Solution {
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        adj = adjList(V,edges,adj);
        
        int[] vis = new int[V];
        
        for(int i = 0 ; i < V ; i++){
            if(vis[i]==0){
                if(dfs(i,-1,vis,adj)==true)return true;
            }
        }
        
        return false;
    }
    
    public boolean dfs(int node,int parent ,int[] vis ,ArrayList<ArrayList<Integer>> adj) {
        vis[node]=1;
        
        for(int ele : adj.get(node)){
            if(vis[ele]==0){
                if(dfs(ele,node,vis,adj))return true;
            }else{
                if(ele!=parent)return true;
            }
        }
        return false;
    }
    
    public ArrayList<ArrayList<Integer>> adjList(int n, int[][] edges,ArrayList<ArrayList<Integer>> adj) {
        for(int[] arr : edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }

        return adj;
    }
}
