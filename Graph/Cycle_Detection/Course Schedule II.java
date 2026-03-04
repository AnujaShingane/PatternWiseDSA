class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = adjecencyList(numCourses,prerequisites);
        int[] ans = topoSort(numCourses,prerequisites);

        return ans;
    }

    public int[] topoSort(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = adjecencyList(numCourses,prerequisites);
        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0 ; i < numCourses ; i++){
            if(!vis[i]){
                if(dfs(i,-1,vis,pathVis,adj,st)){
                    return new int[0];
                }
            }
        }
        
        int[] ans = new int[numCourses];
        int i = 0;
        while(!st.isEmpty()){
            ans[i++] = st.pop();
        }

        return ans;
    }
    
    public boolean dfs(int node,int parent, boolean[] vis, boolean[] pathVis,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st){
        vis[node]=true;
        pathVis[node] = true;
        
        for(int ele : adj.get(node)){
            if(!vis[ele]){
                if(dfs(ele,node,vis,pathVis,adj,st))return true;
            }
            else if(vis[ele] && pathVis[ele]){
                return true;
            }
        }
        
        pathVis[node]=false;
        st.push(node);
        return false;
    }

    public ArrayList<ArrayList<Integer>> adjecencyList(int numCourses,int[][] prerequisites){
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
