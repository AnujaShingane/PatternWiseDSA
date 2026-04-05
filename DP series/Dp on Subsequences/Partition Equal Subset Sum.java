class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int ele : nums){
            sum+=ele;
        }
        if(sum%2!=0)return false;
        int target = sum/2;

        return func(n-1,nums,target);
    }

    public boolean func(int ind,int[] nums,int target) {
        if(target == 0)return true;
        if(ind==0)return nums[0]==target;

        boolean take = false;
        if(nums[ind]<=target)take = func(ind-1,nums,target-nums[ind]);
        boolean nottake = func(ind-1,nums,target);

        return take || nottake;
    }
}




class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int ele : nums){
            sum+=ele;
        }
        if(sum%2!=0)return false;
        int target = sum/2;
        Boolean[][] dp = new Boolean[n][target+1]; 

        return func(n-1,nums,target,dp);
    }

    public boolean func(int ind,int[] nums,int target,Boolean[][] dp) {
        if(target == 0)return true;
        if(ind==0)return nums[0]==target;

        if(dp[ind][target]!=null)return dp[ind][target];

        boolean take = false;
        if(nums[ind]<=target)take = func(ind-1,nums,target-nums[ind],dp);
        boolean nottake = func(ind-1,nums,target,dp);

        return dp[ind][target] = take || nottake;
    }
}


class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int ele : nums){
            sum+=ele;
        }
        if(sum%2!=0)return false;
        int target = sum/2;
        boolean[][] dp = new boolean[n][target+1];

        for(int i = 0 ; i < n ; i++){
            dp[i][0] = true;
        }
        if(nums[0]<=target)dp[0][nums[0]]=true;

        for(int i = 1 ; i < n ; i++){
            for(int t = 0 ; t <= target ; t++){
                boolean take = false;
                if(nums[i]<=t)take = dp[i-1][t-nums[i]];
                boolean nottake = dp[i-1][t];

                dp[i][t] = take || nottake;        
            }
        }

        return dp[n-1][target];
    }
}
