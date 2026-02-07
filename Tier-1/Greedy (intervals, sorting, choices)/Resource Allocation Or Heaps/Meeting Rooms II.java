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
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i = 0 ; i < n ; i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;
        int maxrooms = 0;
        int i = 0;
        int j = 0;

        while(i<n){
            if(start[i]<end[j]){
                rooms++;
                i++;
                maxrooms = Math.max(maxrooms,rooms);
            }else{
                rooms--;
                j++;
            }
        }

        return maxrooms;
    }
}

