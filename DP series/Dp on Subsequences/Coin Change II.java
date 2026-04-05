class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] arr1 : dp){
            Arrays.fill(arr1,-1);
        }
        
        int ans = func(n-1,coins,amount,dp);
        return ans;
    }

    static int func(int ind,int[] num,int amt,int[][] dp) {
        if(amt==0){
            return 1;
        }

        if(ind==0){
            if(amt==num[0])return 1;
        }

        if(ind<0)return 0;

        if(dp[ind][amt]!=-1)return dp[ind][amt];

        int take = 0;
        if(num[ind]<= amt)take = func(ind,num,amt-num[ind],dp);
        int nottake = func(ind-1,num,amt,dp);

        return dp[ind][amt] = take + nottake;
    }
}
