/*
You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of the longest substring that contains exactly k distinct characters.

Note : If no such substring exists, return -1. 

Examples:

Input: s = "aabacbebebe", k = 3
Output: 7
Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.
Input: s = "aaaa", k = 2
Output: -1
Explanation: There's no substring with 2 distinct characters.
Input: s = "aabaaab", k = 2
Output: 7
Explanation: The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b', making it the longest valid substring.
*/

class Solution {
    public int longestKSubstr(String s, int k) {
        int n = s.length();
        int l = 0;
        int r = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int maxlen = -1;
        
        while(r<n){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            
            while(map.size()>k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0)map.remove(s.charAt(l));
                l++;
            }
            
            if(map.size()==k)maxlen = Math.max(maxlen,r-l+1);
            r++;
        }
        
        return maxlen;
    }
}
