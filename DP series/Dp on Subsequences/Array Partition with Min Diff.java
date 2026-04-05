import java.util.*;

public class Solution {
    public static int minSubsetSumDifference(int []arr, int n) {
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum+=arr[i];
        }
        int[][] dp = new int[n][sum+1];
        for(int[] arr1 : dp){
            Arrays.fill(arr1,-1);
        }

        return func(n-1,0,sum,arr,dp);
    }

    public static int func(int ind,int s1,int sum,int[] arr,int[][] dp) {
        if(ind<0){
            return Math.abs(sum-2*s1);
        }

          if(dp[ind][s1]!=-1)return dp[ind][s1];

        int take = 0;
        if(arr[ind]<=sum)take = func(ind-1,s1+arr[ind],sum,arr,dp);
        int nottake = func(ind-1,s1,sum,arr,dp);

        return dp[ind][s1] = Math.min(take,nottake);
    }
}
