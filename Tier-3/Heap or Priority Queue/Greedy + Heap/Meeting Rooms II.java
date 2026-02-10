/*
Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), find the minimum number of days required to schedule all meetings without any conflicts.

Note: (0,8),(8,10) is not considered a conflict at 8.

Example 1:

Input: intervals = [(0,40),(5,10),(15,20)]

Output: 2
Explanation:
day1: (0,40)
day2: (5,10),(15,20)

Example 2:

Input: intervals = [(4,9)]

Output: 1
*/


/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        if(n==0)return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Collections.sort(intervals,(a,b)->a.start-b.start);
        pq.add(intervals.get(0).end);

        for(int i = 1 ; i < n ; i++){
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;

            if(start>=pq.peek()){
                pq.poll();
            }

            pq.add(end);
        }

        return pq.size();
    }
}
