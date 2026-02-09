/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,2]

Example 2:

Input: nums = [1], k = 1

Output: [1]

Example 3:

Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

Output: [1,2]
*/


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();

        for(int ele : nums){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> b[1]-a[1]
        );

        for(int key : map.keySet()){
            pq.add(new int[]{key,map.get(key)});
            // if(pq.size()>k){
            //     pq.poll();
            // }
        }

        int[] ans = new int[k];
        for(int i = 0 ; i < k ; i++){
            ans[i]=pq.poll()[0];
        }

        return ans;
    }
}
