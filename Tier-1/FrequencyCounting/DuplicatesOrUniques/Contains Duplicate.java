/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]

Output: true

Explanation:

The element 1 occurs at the indices 0 and 3.

Example 2:

Input: nums = [1,2,3,4]

Output: false
*/


class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(int value : map.values()){
            if(value > 1)return true;
        }
        return false;
    }
}
