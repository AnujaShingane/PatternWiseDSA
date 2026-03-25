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
    Boolean[][] dp;

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int num : nums) sum += num;

        if(sum % 2 != 0) return false;

        int target = sum / 2;
        dp = new Boolean[n][target + 1];

        return f(n - 1, target, nums);
    }

    boolean f(int i, int target, int[] arr){
        if(target == 0) return true;
        if(i == 0) return arr[0] == target;

        if(dp[i][target] != null) return dp[i][target];

        boolean notTake = f(i - 1, target, arr);

        boolean take = false;
        if(arr[i] <= target)
            take = f(i - 1, target - arr[i], arr);

        return dp[i][target] = take || notTake;
    }
}


Tabu -->
class Solution {
    public boolean canPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;

        for(int num : arr) sum += num;

        if(sum % 2 != 0) return false;

        int k = sum / 2;

        boolean[][] dp = new boolean[n][k + 1];

        for(int i = 0; i < n; i++) dp[i][0] = true;

        if(arr[0] <= k) dp[0][arr[0]] = true;

        for(int i = 1; i < n; i++){
            for(int t = 1; t <= k; t++){
                boolean notTake = dp[i - 1][t];

                boolean take = false;
                if(arr[i] <= t)
                    take = dp[i - 1][t - arr[i]];

                dp[i][t] = take || notTake;
            }
        }

        return dp[n - 1][k];
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
