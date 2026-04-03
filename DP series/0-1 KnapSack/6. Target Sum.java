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
