"""
  You are given an array 'arr' of size 'n' containing positive integers and a target sum 'k'.
Find the number of ways of selecting the elements from the array such that the sum of chosen elements is equal to the target 'k'.
Since the number of ways can be very large, print it modulo 10 ^ 9 + 7.

Example:
Input: 'arr' = [1, 1, 4, 5]

Output: 3

Explanation: The possible ways are:
[1, 4]
[1, 4]
[5]
Hence the output will be 3. Please note that both 1 present in 'arr' are treated differently.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
4 5
1 4 4 5
Sample Output 1 :
 3

Explanation For Sample Output 1:
The possible ways are:
[1, 4]
[1, 4]
[5]
Hence the output will be 3. Please note that both 1 present in 'arr' are treated differently.
"""

Recur-->
public class Solution {
    public static int findWays(int num[], int tar) {
        int n = num.length;
        int MOD = (int)(1e9+7);
        return func(n-1,tar,num,MOD);
    }

    public static int func(int i , int tar,int[] num,int MOD){
        if(i == 0){
            if(tar == 0 && num[0] == 0) return 2; // take or not take
            if(tar == 0 || num[0] == tar) return 1;
            return 0;
        }

        int nottake = func(i-1,tar,num,MOD);
        int take = 0;
        if(num[i]<=tar)take = func(i-1,tar-num[i],num,MOD);

        return (nottake+take)%MOD;
    }
}

Memo-->
  
public class Solution {
    public static int findWays(int num[], int tar) {
        int n = num.length;
        int MOD = (int)(1e9+7);
        int[][] dp = new int[n][tar+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return func(n-1,tar,num,dp,MOD);
    }

    public static int func(int i , int tar,int[] num,int[][] dp,int MOD){
        if(i == 0){
            if(tar == 0 && num[0] == 0) return 2; // take or not take
            if(tar == 0 || num[0] == tar) return 1;
            return 0;
        }

        if(dp[i][tar]!= -1)return dp[i][tar];

        int nottake = func(i-1,tar,num,dp,MOD);
        int take = 0;
        if(num[i]<=tar)take = func(i-1,tar-num[i],num,dp,MOD);

        return dp[i][tar] = (nottake+take)%MOD;
    }
}


Tabu -->
public class Solution {
    public static int findWays(int num[], int tar) {
        int n = num.length;
        int MOD = (int)(1e9+7);
        int[][] dp = new int[n][tar+1];
        for(int[] arr : dp){
            Arrays.fill(arr,0);
        }

        //for i==0
        if(num[0]==0){
            dp[0][0] = 2;//take or nottake
        }else{
            dp[0][0] = 1;//nottake
        }

        if(num[0]!= 0 && num[0]<=tar){
            dp[0][num[0]] = 1;//take
        }

        for(int i = 1 ; i < n ; i++){
            for(int t = 0 ; t <= tar ; t++){
                int nottake = dp[i-1][t];
                int take = 0;
                if(num[i]<=t)take = dp[i-1][t-num[i]];

                dp[i][t] = (nottake+take)%MOD;
            }
        }

        return dp[n-1][tar];
    }
}
