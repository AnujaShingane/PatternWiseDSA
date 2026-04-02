Recursion ->

class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        return f(n-1,W,val,wt);
    }
    
    public int f(int ind,int W,int[] val,int[] wt) {
        if(ind==0){
            if(wt[ind]<=W){
                return val[ind];
            }else return 0;
        }
        
        int nottake = f(ind-1,W,val,wt);
        
        int take = Integer.MIN_VALUE;
        if(wt[ind]<=W){
            take = val[ind] + f(ind-1,W-wt[ind],val,wt);
        }
        
        return Math.max(take,nottake);
    }
}

Memo->

class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n+1][W+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return f(n-1,W,val,wt,dp);
    }
    
    public int f(int ind,int W,int[] val,int[] wt,int[][] dp) {
        if(ind==0){
            if(wt[ind]<=W){
                return val[ind];
            }else return 0;
        }
        
        if(dp[ind][W] != -1)return dp[ind][W];
        
        int nottake = f(ind-1,W,val,wt,dp);
        
        int take = Integer.MIN_VALUE;
        if(wt[ind]<=W){
            take = val[ind] + f(ind-1,W-wt[ind],val,wt,dp);
        }
        
        return dp[ind][W] =Math.max(take,nottake);
    }
}

Tabu ->

class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n+1][W+1];
        
        for(int w = wt[0] ; w <= W ; w++){
            dp[0][w] = val[0];
        }
        
        for(int i = 1 ; i < n ; i++){
            for(int w = 0 ; w <= W ; w++){
                int nottake = dp[i-1][w];
        
                int take = Integer.MIN_VALUE;
                if(wt[i]<=w){
                    take = val[i] + dp[i-1][w-wt[i]];
                }
                
                dp[i][w] = Math.max(take,nottake);
            }
        }
        
        return dp[n-1][W];
    }
}
