/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,1);
        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
            if(map.containsKey(sum-k))cnt+=map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}
