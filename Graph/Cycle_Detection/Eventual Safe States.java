class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        int[] outdegree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            outdegree[i]=graph[i].length;
            if(outdegree[i]==0)q.add(i);
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < n ; i++){
            int[] arr = graph[i];
            for(int ele : arr){
                adj.get(ele).add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);

            for(int ele : adj.get(node)){
                outdegree[ele]--;
                if(outdegree[ele]==0)q.offer(ele);
            }
        }

        Collections.sort(ans);
        return ans;
    }
}
