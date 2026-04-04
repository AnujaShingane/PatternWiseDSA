Memo ->

import java.util.* ;
import java.io.*; 
import java.util.*;
public class Solution {
	static int notpick = 0;
  public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int n = nums.size();
		int[] dp = new int[n];
		Arrays.fill(dp,-1);

		return func(n-1,nums,dp);
	}

	public static int func(int ind,ArrayList<Integer> nums,int[] dp) {
		if(ind==0)return nums.get(0);
		if(ind<0)return 0;

		if(dp[ind]!=-1)return dp[ind];

		int pick = nums.get(ind) + func(ind-2,nums,dp);
		notpick = func(ind-1,nums,dp);

		return dp[ind] = Math.max(pick,notpick);
	}
}

Tabulation -> 

import java.util.* ;
import java.io.*; 
import java.util.*;
public class Solution {
	static int notpick = 0;
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int n = nums.size();
		int[] dp = new int[n];

		dp[0]=nums.get(0);

		for(int i = 1 ; i < n ; i++){
			int pick = nums.get(i);
			if(i>1)pick = nums.get(i) + dp[i-2];
			notpick = dp[i-1];

			dp[i] = Math.max(pick,notpick);
		}

		return dp[n-1];
	}
}
