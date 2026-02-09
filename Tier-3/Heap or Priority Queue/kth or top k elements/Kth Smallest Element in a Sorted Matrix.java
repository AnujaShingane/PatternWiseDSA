Binary Search would be better here 


Max heap soln :

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int[] arr : matrix){
            for(int ele : arr){
                pq.add(ele);
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }

        return pq.peek();
    }
}
