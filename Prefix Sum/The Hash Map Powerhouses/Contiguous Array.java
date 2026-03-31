"""
525. Contiguous Array
Solved
Medium
Topics
premium lock icon
Companies
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Example 3:

Input: nums = [0,1,1,1,1,1,0,0,0]
Output: 6
Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.  
"""


class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int zeros = 0;
        int ones = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int len = 0;
        int maxlen = 0;

        for(int i = 0 ; i < n ; i++){
            if(nums[i]==0)zeros++;
            else ones++;
            int diff = zeros-ones;

            if(map.containsKey(diff)){
                len = i-map.get(diff);
                maxlen = Math.max(len,maxlen);
            }else{
                map.put(diff,i);
            }
        }

        return maxlen;
    }
}
