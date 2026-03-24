//recursion
public static boolean helper(int idx, int[] arr, int target){
    if(target == 0) return true;
    if(idx == 0) return arr[0] == target;
    
    // take
    boolean take = false;
    if(arr[idx] <= target) take = helper(idx - 1, arr, target - arr[idx]);
    
    // not-take
    boolean notTake = helper(idx - 1, arr, target);
    
    return take || notTake;
}


//Memo

public static boolean helper(int idx, int[] arr, int target, Boolean[][] dp){
       if(target == 0) return true;
       if(idx == 0) return arr[0] == target;
       
       if(dp[idx][target] != null) return dp[idx][target];
       
       // take
       boolean take = false;
       if(arr[idx] <= target) take = helper(idx - 1, arr, target - arr[idx], dp);
       
       // not-take
       boolean notTake = helper(idx - 1, arr, target, dp);
       
       return dp[idx][target] = take || notTake;
    }
    public static Boolean isSubsetSum(int N, int arr[], int sum){
      Boolean[][] dp = new Boolean[N][sum + 1];
      return helper(N - 1, arr, sum, dp);
} 


//tabulation

public static Boolean isSubsetSum(int n, int arr[], int sum){
   boolean[][] dp = new boolean[n][sum + 1];
   for(int i = 0; i < n; i++){
       dp[i][0] = true;
   }
   if(arr[0]<= sum){
       dp[0][arr[0]] = true;
   }
   
   for(int idx = 1; idx < n; idx++){
       for(int target = 1; target <= sum; target++){
           // take
           boolean take = false;
           if(arr[idx] <= target) take = dp[idx - 1][target - arr[idx]];
               
           // not-take
           boolean notTake = dp[idx - 1][target];
           
           dp[idx][target] = take || notTake;
       }
   }
   return dp[n - 1][sum];
}


//space optimization

// Space Optimization
public static Boolean isSubsetSum(int n, int arr[], int sum){
    boolean[] prev = new boolean[sum + 1];
    boolean[] curr = new boolean[sum + 1];
    
    prev[0] = curr[0] = true;
    
    if(arr[0]<= sum){
        prev[arr[0]] = true;
    }
    
    for(int idx = 1; idx < n; idx++){
        for(int target = 1; target <= sum; target++){
            // take
            boolean take = false;
            if(arr[idx] <= target) take = prev[target - arr[idx]];
                
            // not-take
            boolean notTake = prev[target];
            
            curr[target] = take || notTake;
        }
        prev = curr.clone();
    }
    return prev[sum];
}
