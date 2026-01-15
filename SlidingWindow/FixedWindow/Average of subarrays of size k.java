/*
Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
Example 2:

Input: nums = [5], k = 1
Output: 5.00000

*/


class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double max;

        // first window
        for (int z = 0; z < k; z++) {
            sum += nums[z];
        }
        max = sum;   // store sum, not average

        int i = 0;   // left pointer
        int j = k-1;   // right pointer

        while (j < nums.length-1) {
            sum -= nums[i];   // remove left
            i++;
            
            j++;
            sum += nums[j];   //add right

            max = Math.max(max, sum);
        }

        return max / k;
    }
}
