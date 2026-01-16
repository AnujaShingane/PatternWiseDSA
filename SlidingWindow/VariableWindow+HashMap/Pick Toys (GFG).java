/*
Given an array arr[ ] of length N consisting cost of N toys and an integer K depicting the amount with you. Your task is to find maximum number of toys you can buy with K amount. 

Example 1:

Input: 
N = 7 
K = 50
arr[] = {1, 12, 5, 111, 200, 1000, 10}
Output: 4
Explaination: The costs of the toys 
you can buy are 1, 12, 5 and 10.
Example 2:

Input: 
N = 3 
K = 100
arr[] = {20, 30, 50}
Output: 3
Explaination: You can buy all toys.
*/


class Solution {
    static int toyCount(int N, int K, int arr[]) {
        int n = arr.length;
        Arrays.sort(arr);
        int cnt = 0;
        int sum=0;
        
        for(int i = 0 ; i < n ; i++){
            if(arr[i]<K && sum+arr[i]<=K){
                sum+=arr[i];
                cnt++;
            }
        }
        
        return cnt;
    }
}
