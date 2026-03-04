class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = adjList(numCourses,prerequisites);
        boolean cycle = isCycle(numCourses,adj);

        if(!cycle)return true;
        return false;
    }

    public boolean isCycle(int numCourses,ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        for(int i = 0 ; i < numCourses ; i++){
            if(!vis[i]){
                if(dfs(i,vis,pathVis,adj))return true;
            }
        }

        return false;
    }

    public boolean dfs(int node,boolean[] vis,boolean[] pathVis,ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        pathVis[node] = true;

        for(int ele : adj.get(node)){
            if(!vis[ele]){
                if(dfs(ele,vis,pathVis,adj))return true;
            }else{
                if(pathVis[ele])return true;
            }
        }

        pathVis[node]=false;
        return false;
    }

    public ArrayList<ArrayList<Integer>> adjList(int numCourses,int[][] prerequisites){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] arr : prerequisites){
            adj.get(arr[1]).add(arr[0]);
        }

        return adj;
    }
}
