"""
  Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum equal to given sum. 

Examples:

Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
Output: true 
Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.
Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
Output: false
Explanation: There is no subset with target sum 30.
Input: arr[] = [1, 2, 3], sum = 6
Output: true
Explanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.
"""


Recursive -->

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        return f(n-1,sum,arr);
    }
    
    public static boolean f(int ind,int target,int[] arr){
        if(target==0)return true;
        if(ind==0)return arr[0]==target;
        
        boolean nottake = f(ind-1,target,arr);
        boolean take = false;
        if(target>=arr[ind])take = f(ind-1,target-arr[ind],arr);
        
        return take || nottake;
    }
}


Memo -->

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][sum+1];
        return f(n-1,sum,arr,dp);
    }
    
    public static boolean f(int ind,int target,int[] arr,Boolean[][] dp){
        if(target==0)return true;
        if(ind==0)return arr[0]==target;
        
        if(dp[ind][target]!=null)return dp[ind][target];
        
        boolean nottake = f(ind-1,target,arr,dp);
        boolean take = false;
        if(target>=arr[ind])take = f(ind-1,target-arr[ind],arr,dp);
        
        return dp[ind][target] = take || nottake;
    }
}


Tabu -->

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][sum+1];
        
        for(int i = 0 ; i < n ; i++)dp[i][0]=true;
        if(arr[0]<=sum)dp[0][arr[0]]=true;
        
        for(int i = 1 ; i < n ; i++){
            for(int t = 1 ; t<=sum ; t++){
                boolean nottake = dp[i-1][t];
                boolean take = false;
                if(t>=arr[i])take = dp[i-1][t-arr[i]];
                
                dp[i][t] = take || nottake;
            }
        }
        
        return dp[n-1][sum];
    }
}
