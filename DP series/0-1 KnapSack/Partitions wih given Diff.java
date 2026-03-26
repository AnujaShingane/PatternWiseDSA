Recursive -->

public class Solution {
	public static int countPartitions(int n, int d, int[] arr) {
		int totalSum=0;
		int MOD = (int)(1e9+7);
		for(int num : arr)totalSum+=num;
		if(totalSum - d < 0 || (totalSum - d) % 2 != 0) return 0;
		int target = (totalSum - d) / 2;

		return func(n-1,target,arr,MOD);
	}

	public static int func(int ind,int target,int[] arr,int MOD) {
		if(ind==0){
			if(target==0 && arr[0]==0)return 2;
			if(target==0 || arr[0]==target)return 1;
			return 0;
		}

		int nottake = func(ind-1,target,arr,MOD);
		int take = 0;
		if(arr[ind]<=target)take = func(ind-1,target-arr[ind],arr,MOD);

		return (nottake+take)%MOD;
	}
}

Memo -->

public class Solution {
	public static int countPartitions(int n, int d, int[] arr) {
		int totalSum=0;
		int MOD = (int)(1e9+7);
		for(int num : arr)totalSum+=num;
		if(totalSum - d < 0 || (totalSum - d) % 2 != 0) return 0;//if less or odd -> return 0
		
		int target = (totalSum - d) / 2;

		int[][] dp = new int[n][target+1];
		for(int[] a : dp){
			Arrays.fill(a,-1);
		}

		return func(n-1,target,dp,arr,MOD);
	}

	public static int func(int ind,int target,int[][] dp,int[] arr,int MOD) {
		if(ind==0){
			if(target==0 && arr[0]==0)return 2;
			if(target==0 || arr[0]==target)return 1;
			return 0;
		}

		if(dp[ind][target]!=-1)return dp[ind][target];

		int nottake = func(ind-1,target,dp,arr,MOD);
		int take = 0;
		if(arr[ind]<=target)take = func(ind-1,target-arr[ind],dp,arr,MOD);

		return dp[ind][target] = (nottake+take)%MOD;
	}
}




Tabu -->

public class Solution {
	public static int countPartitions(int n, int d, int[] arr) {
		int totalSum=0;
		int MOD = (int)(1e9+7);
		for(int num : arr)totalSum+=num;
		if(totalSum - d < 0 || (totalSum - d) % 2 != 0) return 0;//if less or odd -> return 0
		
		int target = (totalSum - d) / 2;

		int[][] dp = new int[n][target+1];

		if(arr[0]==0){
			dp[0][0] = 2;//take or nottake
		}else{
			dp[0][0] = 1;//nottake
		}

		if(arr[0]!=0 && arr[0]<=target){
			dp[0][arr[0]]=1; // take
		}

		for(int i = 1 ; i < n ; i++){
			for(int t = 0 ; t <= target ; t++){
				int nottake = dp[i-1][t];
				int take = 0;
				if(arr[i]<=t)take = dp[i-1][t-arr[i]];

				dp[i][t] = (nottake+take)%MOD;
			}
		}

		return dp[n-1][target];
	}
}
