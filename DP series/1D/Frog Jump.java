Recursion ->
  
import java.util.* ;
import java.io.*; 
public class Solution {
    static int right = 0;
    public static int frogJump(int n, int heights[]) {
        return func(n-1,heights);
    }

    public static int func(int ind,int[] heights) {
        if(ind==0)return 0;
        if(ind==1)return Math.abs(heights[1]-heights[0]);

        int left = func(ind-1,heights) + Math.abs(heights[ind]-heights[ind-1]);
        if(ind>1)right = func(ind-2,heights) + Math.abs(heights[ind]-heights[ind-2]);

        return Math.min(left,right);
    }
}

Memo ->

import java.util.* ;
import java.io.*; 
public class Solution {
    static int right = 0;
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return func(n-1,heights,dp);
    }

    public static int func(int ind,int[] heights,int[] dp) {
        if(ind==0)return 0;
        if(ind==1)return Math.abs(heights[1]-heights[0]);

        if(dp[ind]!=-1)return dp[ind];

        int left = func(ind-1,heights,dp) + Math.abs(heights[ind]-heights[ind-1]);
        if(ind>1)right = func(ind-2,heights,dp) + Math.abs(heights[ind]-heights[ind-2]);

        return dp[ind] = Math.min(left,right);
    }
}


Tabu -> 
  
import java.util.* ;
import java.io.*; 
public class Solution {
    static int right = 0;
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(heights[1]-heights[0]);

        for(int i = 2 ; i < n ; i++){
            int left = dp[i-1] + Math.abs(heights[i]-heights[i-1]);
            if(i>1)right = dp[i-2]+ Math.abs(heights[i]-heights[i-2]);

            dp[i] = Math.min(left,right);
        }

        return dp[n-1];
    }
}
