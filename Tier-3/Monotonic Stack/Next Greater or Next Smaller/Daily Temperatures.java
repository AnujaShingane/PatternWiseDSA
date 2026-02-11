/*
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]
*/


class Pair{
    int val;
    int idx;

    Pair(int val, int idx){
        this.val = val;
        this.idx = idx;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Pair> st = new Stack<>();

        for(int i = n-1 ; i>=0 ; i--){
            int curval = temperatures[i];
            int curidx = i;

            while(!st.isEmpty() && st.peek().val<=curval){
                st.pop();
            }

            if(st.isEmpty()){
                res[i]=0;
            }else{
                res[i]=st.peek().idx-curidx;
            }

            st.push(new Pair(curval,curidx));
        }

        return res;
    }
}
