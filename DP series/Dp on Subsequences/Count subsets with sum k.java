import java.util.*;
import java.io.*;

public class Solution {
    static double MOD = 1e9+7;
    public static int findWays(int num[], int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar+1];
        for(int[] arr1 : dp){
            Arrays.fill(arr1,-1);
        }

        return func(n-1,num,tar,dp);
    }

    public static int func(int ind,int[] num,int tar,int[][] dp) {
        if(ind==0){
            if(tar==0 && num[0]==0)return 2;
            if(tar==0 || num[0]==tar)return 1;
            else return 0;
        }

        if(dp[ind][tar]!=-1)return dp[ind][tar];

        int take = 0;
        if(num[ind]<= tar)take = func(ind-1,num,tar-num[ind],dp);
        int nottake = func(ind-1,num,tar,dp);

        return dp[ind][tar] = (int)((take + nottake)%MOD);
    }
}



import java.util.*;
import java.io.*;

public class Solution {
    static int MOD = (int)(1e9 + 7);

    public static int findWays(int num[], int tar) {
        int n = num.length;

        int[][] dp = new int[n][tar + 1];

        // base case
        if (num[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;

        if (num[0] != 0 && num[0] <= tar) {
            dp[0][num[0]] = 1;
        }

        // fill dp
        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= tar; t++) {

                int notTake = dp[i - 1][t];

                int take = 0;
                if (num[i] <= t) {
                    take = dp[i - 1][t - num[i]];
                }

                dp[i][t] = (take + notTake) % MOD;
            }
        }

        return dp[n - 1][tar];
    }
}
