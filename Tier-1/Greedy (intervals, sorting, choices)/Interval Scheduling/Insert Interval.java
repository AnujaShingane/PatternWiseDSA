/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
*/


class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> list1 = new ArrayList<>();
        for(int[] arr : intervals){
            list1.add(arr);
        }
        list1.add(newInterval);

        Collections.sort(list1,(a,b) -> a[0]-b[0]);

        List<int[]> list2 = new ArrayList<>();
        list2.add(list1.get(0));
        int last = list1.get(0)[1];

        for(int i = 1 ; i < list1.size() ; i++){
            if(list1.get(i)[0]<=last){
                list2.get(list2.size()-1)[1] = Math.max(list2.get(list2.size()-1)[1],list1.get(i)[1]);
                last = list2.get(list2.size() - 1)[1];
            }else if(list1.get(i)[0]<=last && list1.get(i)[1]<=last){

            }else{
                list2.add(list1.get(i));
                last = list1.get(i)[1];
            }
        }

        int[][] res = new int[list2.size()][2];
        for(int i = 0 ; i < list2.size() ; i++){
            res[i] = list2.get(i);
        }
        return res;
    }
}
