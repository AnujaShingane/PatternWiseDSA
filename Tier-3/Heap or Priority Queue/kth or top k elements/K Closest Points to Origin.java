/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

Example 1:


Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.
*/


class Pair{
    int[] arr;
    int dist;

    Pair(int[] arr, int dist){
        this.arr = arr;
        this.dist = dist;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int m = points.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.dist-b.dist
        );

        for(int[] pt : points){
            int x = pt[0];
            int y = pt[1];

            int dis = x*x + y*y;

            pq.add(new Pair(pt,dis));
        }


        int[][] res = new int[k][2];
        for(int i = 0 ; i < k ; i++){
            Pair pair = pq.poll();

            res[i][0]=pair.arr[0];
            res[i][1]=pair.arr[1];
        }

        return res;
    }
}
