/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 
*/


class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        int[] JNleftGreater = new int[n];
        int[] JNrightGreater = new int[n];

        JNleftGreater = JNleftGreaterr(heights);
        JNrightGreater = JNrightGreaterr(heights);

        for(int i = 0 ; i < n ; i++){
            int width = JNleftGreater[i]+JNrightGreater[i]+1;
            maxArea = Math.max(maxArea,width*heights[i]);
        }

        return maxArea;
    }

    public static int[] JNleftGreaterr(int[] heights){
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];

        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }

            if(st.isEmpty()){
                res[i] = i;
            }else{
                res[i] = i-st.peek()-1;
            }
            st.push(i);
        }
        return res;
    }

    public static int[] JNrightGreaterr(int[] heights){
        int n = heights.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n-1 ; i >= 0 ; i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }

            if(st.isEmpty()){
                res[i] = n-i-1;
            }else{
                res[i] = st.peek()-i-1;
            }

            st.push(i);
        }

        return res;
    }
}
