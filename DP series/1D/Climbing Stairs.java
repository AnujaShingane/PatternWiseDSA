Recursion ->

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        return func(n,dp);
    }

    public int func(int ind,int[] dp) {
        if(ind == 0)return 1;
        if(ind == 1)return 1;

        if(dp[ind]!= -1)return dp[ind];

        int left = func(ind-1,dp);
        int right = func(ind-2,dp);

        return dp[ind] = left + right;
    }
}

Memo ->

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        dp[0]=1;
        dp[1]=1;

        for(int i = 2 ; i < n ; i++){
            int left = dp[i-1];
            int right = dp[i-2];

            dp[i] = left + right;
        }

        return func(n,dp);
    }

    public int func(int ind,int[] dp) {
        if(ind == 0)return 1;
        if(ind == 1)return 1;

        if(dp[ind]!= -1)return dp[ind];

        int left = func(ind-1,dp);
        int right = func(ind-2,dp);

        return dp[ind] = left + right;
    }
}


Tabulation ->
  
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];

        dp[0]=1;
        dp[1]=1;

        for(int i = 2 ; i <= n ; i++){
            int left = dp[i-1];
            int right = dp[i-2];

            dp[i] = left + right;
        }

        return dp[n];
    }
}
