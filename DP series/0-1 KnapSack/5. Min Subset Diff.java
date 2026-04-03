Recursion ->

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int ele : nums){
            sum += ele;
        }

        return func(n-1,nums,0,0,n/2,sum);
    }

    public int func(int ind,int[] nums,int cnt,int sum,int n,int tS) {
        if(cnt==n){
            return Math.abs(tS-2*sum);
        }

        if(ind<0){
            return Integer.MAX_VALUE;
        }

        int nottake = func(ind-1,nums,cnt,sum,n,tS);
        int take = Integer.MIN_VALUE;
        take = func(ind-1,nums,cnt+1,sum+nums[ind],n,tS);

        return Math.min(take,nottake);
    }
}

Memo -> 

import java.util.*;

class Solution {
    @SuppressWarnings("unchecked")
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // Arrays of lists to store subset sums, grouped by the number of elements chosen
        List<Integer>[] leftSums = new ArrayList[n + 1];
        List<Integer>[] rightSums = new ArrayList[n + 1];
        
        for (int i = 0; i <= n; i++) {
            leftSums[i] = new ArrayList<>();
            rightSums[i] = new ArrayList<>();
        }
        
        // Generate all subset sums for both halves using bitmasking
        // Since n <= 15, 1 << n is at most 32768, which is very fast
        int numCombinations = 1 << n;
        for (int mask = 0; mask < numCombinations; mask++) {
            int size = 0;
            int lSum = 0;
            int rSum = 0;
            
            for (int i = 0; i < n; i++) {
                // If the i-th bit is set, include the i-th element
                if ((mask & (1 << i)) != 0) {
                    size++;
                    lSum += nums[i];
                    rSum += nums[i + n];
                }
            }
            leftSums[size].add(lSum);
            rightSums[size].add(rSum);
        }
        
        // Sort the right half subsets so we can use binary search
        for (int i = 0; i <= n; i++) {
            Collections.sort(rightSums[i]);
        }
        
        int minDiff = Integer.MAX_VALUE;
        int target = totalSum / 2;
        
        // Iterate over all possible sizes of subsets picked from the left half
        for (int k = 0; k <= n; k++) {
            List<Integer> leftList = leftSums[k];
            // If we pick k elements from the left, we must pick (n - k) from the right
            List<Integer> rightList = rightSums[n - k]; 
            
            for (int lSum : leftList) {
                // We want: lSum + expectedRight ≈ totalSum / 2
                int expectedRight = target - lSum;
                
                // Binary search for expectedRight in the sorted rightList
                int idx = Collections.binarySearch(rightList, expectedRight);
                
                if (idx >= 0) {
                    // Exact match found (difference will be 0 or as close as mathematically possible)
                    int currentSum = lSum + rightList.get(idx);
                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * currentSum));
                } else {
                    // Insertion point (where the number would belong if it existed)
                    idx = -(idx + 1);
                    
                    // Check the element right at the insertion point (ceiling)
                    if (idx < rightList.size()) {
                        int currentSum = lSum + rightList.get(idx);
                        minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * currentSum));
                    }
                    // Check the element right before the insertion point (floor)
                    if (idx > 0) {
                        int currentSum = lSum + rightList.get(idx - 1);
                        minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * currentSum));
                    }
                }
            }
        }
        
        return minDiff;
    }
}
