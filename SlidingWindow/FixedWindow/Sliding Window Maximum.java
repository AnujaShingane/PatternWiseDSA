/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
*/

class Pair{
    int ind;
    int val;

    Pair(int ind,int val){
        this.ind=ind;
        this.val = val;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n-k+1];

        Deque<Pair> q = new ArrayDeque<>();
        int ind=0;
        for(int i = 0 ; i < n ; i++){

            while(!q.isEmpty() && q.peekLast().val<=nums[i]){
                q.pollLast();
            }

            if(q.isEmpty() || q.peekLast().val>nums[i]){
                q.add(new Pair(i,nums[i]));
            }

            if(!q.isEmpty() && q.peekFirst().ind <= i-k){
                q.pollFirst();
            }

            if(i>=k-1){
                arr[ind++]=q.peekFirst().val;
            }
        }
        
        return arr;
    }
}


// using pq

import java.util.*;

class Pair {
    int idx;
    int val;

    Pair(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int pos = 0;

        // max heap
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.val - a.val
        );

        for (int i = 0; i < n; i++) {
            pq.add(new Pair(i, nums[i]));

            // remove elements that are outside the window
            while (pq.peek().idx <= i - k) {
                pq.poll();
            }

            // when window is ready
            if (i >= k - 1) {
                ans[pos++] = pq.peek().val;
            }
        }

        return ans;
    }
}
