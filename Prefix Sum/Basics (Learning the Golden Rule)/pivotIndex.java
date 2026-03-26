class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] ls = new int[n];
        ls[0] = 0;

        for(int i = 1 ; i < n ; i++){
            ls[i] = ls[i-1]+nums[i-1];
        }
        
        int totalSum = ls[n-1]+nums[n-1];

        for(int i = 0 ; i < n-1 ; i++){
            if(totalSum-ls[i+1]==ls[i])return i;
        }

        if(ls[n-1]==0)return n-1;

        return -1;
    }
}
