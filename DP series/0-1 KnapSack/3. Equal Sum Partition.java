// Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

// Example 1:

// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].
// Example 2:

// Input: nums = [1,2,3,5]
// Output: false
// Explanation: The array cannot be partitioned into equal sum subsets.
 

Recursion -->
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        // Step 1: If sum is odd → not possible
        if(sum % 2 != 0) return false;

        // Step 2: Target = sum / 2
        return f(n - 1, sum / 2, nums);
    }
    
    public boolean f(int i, int target, int[] arr){
        if(target == 0) return true;
        if(i == 0) return arr[0] == target;

        boolean notTake = f(i - 1, target, arr);

        boolean take = false;
        if(arr[i] <= target)
            take = f(i - 1, target - arr[i], arr);

        return take || notTake;
    }
}



Memo -->
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int ele : nums)sum+=ele;
        if(sum%2!=0)return false;
        int target = sum/2;
        Boolean[][] dp = new Boolean[n][sum+1];

        return func(n-1,nums,target,dp);
    }

    public boolean func(int ind,int[] nums,int target,Boolean[][] dp){
        if(target==0)return true;
        if(ind==0){
            return nums[0] == target;
        }

        if(dp[ind][target]!=null)return dp[ind][target];

        boolean nottake = func(ind-1,nums,target,dp);
        boolean take = false;
        if(nums[ind]<= target)take = func(ind-1,nums,target-nums[ind],dp);

        return dp[ind][target] = take || nottake;
    }
}


Tabu -->
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int ele : nums)sum+=ele;
        if(sum%2!=0)return false;
        int target = sum/2;
        boolean[][] dp = new boolean[n][sum+1];

        for(int i = 0 ; i < n ; i++){
            dp[i][0] = true;
        }

        if(target>=nums[0])dp[0][nums[0]] = true;

        for(int ind = 1 ; ind < n ; ind++){
            for(int t = 0 ; t <= sum ; t++){
                boolean nottake = dp[ind-1][t];
                boolean take = false;
                if(nums[ind]<= t)take = dp[ind-1][t-nums[ind]];

                dp[ind][t] = take || nottake;
            }
        }

        return dp[n-1][target];
    }
}



Space Opti -->
class Solution {
    public boolean canPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;

        for(int num : arr) sum += num;

        if(sum % 2 != 0) return false;

        int k = sum / 2;

        boolean[] prev = new boolean[k + 1];
        prev[0] = true;

        if(arr[0] <= k) prev[arr[0]] = true;

        for(int i = 1; i < n; i++){
            boolean[] cur = new boolean[k + 1];
            cur[0] = true;

            for(int t = 1; t <= k; t++){
                boolean notTake = prev[t];

                boolean take = false;
                if(arr[i] <= t)
                    take = prev[t - arr[i]];

                cur[t] = take || notTake;
            }

            prev = cur;
        }

        return prev[k];
    }
}
