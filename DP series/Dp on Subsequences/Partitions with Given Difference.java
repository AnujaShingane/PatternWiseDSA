class Solution {
    public int countPartitions(int[] arr, int diff) {
        // s1-s2 = diff
        // s1+s2 = tS
        // 2s1 = diff+tS
        // s1 = (diff+tS)/2
        
        int n = arr.length;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum+=arr[i];
        }
        if((diff+sum)%2!=0)return 0;
        int target = (diff+sum)/2;
        int[][] dp = new int[n][target+1];
        for(int[] arr1 : dp){
            Arrays.fill(arr1,-1);
        }
        
        return func(n-1,arr,target,dp);
    }
    
    static int func(int ind,int[] num,int tar,int[][] dp) {
        if(ind==0){
            if(tar==0 && num[0]==0)return 2;
            if(tar==0 || num[0]==tar)return 1;
            else return 0;
        }

        if(dp[ind][tar]!=-1)return dp[ind][tar];

        int take = 0;
        if(num[ind]<= tar)take = func(ind-1,num,tar-num[ind],dp);
        int nottake = func(ind-1,num,tar,dp);

        return dp[ind][tar] = (int)((take + nottake));
    }
}
