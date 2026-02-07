Check if in Range -> curr_index < i-k+1


/*
Given an array arr[]  and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.

Note: If a window does not contain a negative integer, then return 0 for that window.

Examples:

Input: arr[] = [-8, 2, 3, -6, 10] , k = 2
Output: [-8, 0, -6, -6]
Explanation:
Window [-8, 2] First negative integer is -8.
Window [2, 3] No negative integers, output is 0.
Window [3, -6] First negative integer is -6.
Window [-6, 10] First negative integer is -6.

Input: arr[] = [12, -1, -7, 8, -15, 30, 16, 28] , k = 3
Output: [-1, -1, -7, -15, -15, 0] 
Explanation:
Window [12, -1, -7] First negative integer is -1.
Window [-1, -7, 8] First negative integer is -1.
Window [-7, 8, -15] First negative integer is -7.
Window [8, -15, 30] First negative integer is -15.
Window [-15, 30, 16] First negative integer is -15.
Window [30, 16, 28] No negative integers, output is 0.
*/


class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < n ; i++){
            if(arr[i]<0)q.add(i);
            
            //start when window become size k
            if(i>=k-1){
                //if out of range remove
                while(!q.isEmpty() && q.peek()<i-k+1){
                    q.poll();
                }
                
                if(q.isEmpty())list.add(0);
                else list.add(arr[q.peek()]);
            }
        }
        return list;
    }
}


//commented 

class Solution {
    static List<Integer> firstNegInt(int nums[], int k) {

        // Length of the input array
        int n = nums.length;

        // List to store the answer for each window
        List<Integer> list = new ArrayList<>();

        // Queue to store INDICES of negative numbers
        // Indices help us check whether a negative number
        // is inside the current window or not
        Queue<Integer> q = new LinkedList<>();

        // Traverse the array using 'i' as the right pointer
        for (int i = 0; i < n; i++) {

            // STEP 1:
            // If current element is negative,
            // store its index in the queue
            if (nums[i] < 0) {
                q.add(i);
            }

            // STEP 2:
            // Start processing only when the window size becomes k
            if (i >= k - 1) {

                // STEP 3:
                // Remove indices of negative numbers
                // that are OUTSIDE the current window
                // Current window range: [i - k + 1, i]
                while (!q.isEmpty() && q.peek() < i - k + 1) {
                    q.poll();
                }

                // STEP 4:
                // If queue is empty → no negative number in this window
                // Else → front of queue is the first negative number
                if (q.isEmpty()) {
                    list.add(0);
                } else {
                    list.add(nums[q.peek()]);
                }
            }
        }

        // Return the list containing first negative number
        // for every window of size k
        return list;
    }
}
