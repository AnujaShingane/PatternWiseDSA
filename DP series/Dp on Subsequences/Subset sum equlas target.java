Recursion ->

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        return func(n-1,arr,sum);
    }
    
    static Boolean func(int ind,int[] arr,int sum) {
        if(sum==0)return true;
        if(ind==0)return arr[ind]==sum;
        
        boolean take = func(ind-1,arr,sum-arr[ind]);
        boolean nottake = func(ind-1,arr,sum);
        
        return take || nottake;
    }
}


Memo ->

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][sum+1];
        
        return func(n-1,arr,sum,dp);
    }
    
    static Boolean func(int ind,int[] arr,int sum,Boolean[][] dp) {
        if(sum==0)return true;
        if(ind==0)return arr[ind]==sum;
        
        if(dp[ind][sum]!=null)return dp[ind][sum];
        
        boolean take = false;
        if(arr[ind]<=sum)take = func(ind-1,arr,sum-arr[ind],dp);
        boolean nottake = func(ind-1,arr,sum,dp);
        
        return dp[ind][sum] = take || nottake;
    }
}


Tabulation ->

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][sum+1];
        
        for(int i = 0 ; i < n ; i++){
            dp[i][0] = true;
        }
        if(arr[0]<=sum)dp[0][arr[0]] = true;
        
        for(int i = 1 ; i < n ; i++){
            for(int s = 0 ; s <= sum ; s++){
                boolean take = false;
                if(arr[i]<=s)take = dp[i-1][s-arr[i]];
                boolean nottake = dp[i-1][s];
                
                dp[i][s] = take || nottake;
            }
        }
        
        return dp[n-1][sum];
    }
}
