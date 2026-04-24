Imp ->
We assign + and - signs.

Let:
Sum of positive numbers = S1
Sum of negative numbers = S2
Then:
S1 - S2 = target
Also:
S1 + S2 = totalSum
✨ Add both equations
S1 - S2 = target
S1 + S2 = totalSum
-------------------
2*S1 = target + totalSum

👉 So:
S1 = (target + totalSum) / 2
🎯 Final Conversion
👉 Problem becomes:
“Count subsets whose sum = (target + totalSum)/2”


// You are given an integer array nums and an integer target.

// You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
// Return the number of different expressions that you can build, which evaluates to target.

 

// Example 1:

// Input: nums = [1,1,1,1,1], target = 3
// Output: 5
// Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
// -1 + 1 + 1 + 1 + 1 = 3
// +1 - 1 + 1 + 1 + 1 = 3
// +1 + 1 - 1 + 1 + 1 = 3
// +1 + 1 + 1 - 1 + 1 = 3
// +1 + 1 + 1 + 1 - 1 = 3
// Example 2:

// Input: nums = [1], target = 1
// Output: 1



Recursive ->
class Solution {
    public int findTargetSumWays(int[] nums, int t) {
        int n = nums.length;
        int sum = 0;
        for(int ele : nums){
            sum+=ele;
        }
        if ((t + sum) % 2 != 0 || Math.abs(t) > sum) {
            return 0;
        }
        
        int target = (t + sum)/2;
        return func(n-1,nums,target);
    }

    public int func(int ind,int[] nums,int target) {
        if(ind==0){
            if(target==0 && nums[0]==0)return 2;
            if(target==0 || nums[0]==target) return 1;
            else return 0;
        }

        int nottake = func(ind-1,nums,target);
        int take = 0;
        if(target>=nums[ind])take = func(ind-1,nums,target-nums[ind]);

        return take + nottake;
    }
}
