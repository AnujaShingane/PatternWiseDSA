class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] arr1 : dp){
            Arrays.fill(arr1,-1);
        }
        
        int ans = func(n-1,coins,amount,dp);
        return ans >= (int)1e9 ? -1 : ans;
    }

    static int func(int ind,int[] num,int amt,int[][] dp) {
        // if(ind==0){
        //     if(tar==0 && num[0]==0)return 2;
        //     if(tar==0 || num[0]==tar)return 1;
        //     else return 0;
        // }

        if(ind==0){
            if(amt%num[0]==0)return amt/num[0];
            else return (int)1e9;
        }

        if(dp[ind][amt]!=-1)return dp[ind][amt];

        int take = (int)1e9;
        if(num[ind]<= amt)take = 1 + func(ind,num,amt-num[ind],dp);
        int nottake = func(ind-1,num,amt,dp);

        return dp[ind][amt] = Math.min(take,nottake);
    }
}
