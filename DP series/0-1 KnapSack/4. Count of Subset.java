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
      class Solution {
        public int perfectSum(int[] nums, int target) {
            int n = nums.length;
            return func(n-1,nums,target);
        }
        
        public int func(int ind,int[] nums,int target) {
            if(ind == 0){
                if(target == 0 && nums[0] == 0) return 2; // include or exclude
                if(target == 0 || nums[0] == target) return 1;
                return 0;
            }
            
            int nottake = func(ind-1,nums,target);
            int take = 0;
            if(target>=nums[ind])take = func(ind-1,nums,target-nums[ind]);
            
            return take+nottake;
        }
}
  }
  
Memo-->
class Solution {
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        
        return func(n-1,nums,target,dp);
    }
    
    public int func(int ind,int[] nums,int target,int[][] dp) {
        if(ind==0){
            if(target==0 && nums[0] == 0)return 2;
            if(target == 0 || target == nums[0])return 1;
            return 0;
        }
        
        if(dp[ind][target]!=-1)return dp[ind][target];
        
        int nottake = func(ind-1,nums,target,dp);
        int take = 0;
        if(target>=nums[ind])take = func(ind-1,nums,target-nums[ind],dp);
        
        return dp[ind][target] = take+nottake;
    }
}

Tabu -->
class Solution {
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        for(int[] arr : dp){
            Arrays.fill(arr,0);
        }
        
        if(nums[0]==0)dp[0][0] = 2;
        else dp[0][0] =1;
        if(nums[0]!= 0 && target>=nums[0])dp[0][nums[0]]=1;
        
        
        for(int i = 1 ; i < n ; i++){
            for(int t = 0 ; t <= target ; t++){
                int nottake = dp[i-1][t];
                int take = 0;
                if(t>=nums[i])take = dp[i-1][t-nums[i]];
                
                dp[i][t] = take+nottake;
            }
        }
        
        return dp[n-1][target];
    }
}
