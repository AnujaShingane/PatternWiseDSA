/*
You are given a 2D matrix mat[][] of size n x m. Each row in the matrix is sorted in non-decreasing order. Your task is to merge all the rows and return a single sorted array that contains all the elements of the matrix.

Examples :

Input: mat[][] = [[1, 3, 5, 7],
                [2, 4, 6, 8], 
                [0, 9, 10, 11]]
Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
Explanation: Merging all elements from the 3 sorted arrays and sorting them results in: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].
Input: mat[][] = [[1, 2, 3, 4], 
                [2, 2, 3, 4],
                [5, 5, 6, 6],
                [7, 8, 9, 9]]
Output: [1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9] 
Explanation: Merging all elements from the 4 sorted arrays and sorting them results in:[1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9]
*/


class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K){
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                pq.add(arr[i][j]);
            }
        }
        
        while(pq.size() != 0){
            list.add(pq.remove());
        }
        
        return list;
    }
}
