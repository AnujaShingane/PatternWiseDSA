/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
*/


class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int num = -1;

        for(int i = 0 ; i < n ;i++){
            if(cnt==0){
                cnt++;
                num=nums[i];
            }else{
                if(nums[i]==num)cnt++;
                else cnt--;
            }
        }

        return num;
    }
}
