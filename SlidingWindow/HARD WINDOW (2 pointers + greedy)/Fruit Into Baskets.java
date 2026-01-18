/*
Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
*/


class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int l = 0;
        int r = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = 0;

        while(r<n){
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);

            if(map.size()>2){
                map.put(fruits[l],map.get(fruits[l])-1);
                if(map.get(fruits[l])==0){
                    map.remove(fruits[l]);
                }
                l++;
            }

            if(map.size()<=2){
                len = Math.max(len,r-l+1);
            }
            r++;
        }
        return len;
    }
}
