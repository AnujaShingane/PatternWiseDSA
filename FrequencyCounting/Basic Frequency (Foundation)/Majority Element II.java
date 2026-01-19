/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
*/


class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(int key : map.keySet()){
            int value = map.get(key);
            if(value>n/3){
                list.add(key);
            }
        }
        return list;
    }
}
