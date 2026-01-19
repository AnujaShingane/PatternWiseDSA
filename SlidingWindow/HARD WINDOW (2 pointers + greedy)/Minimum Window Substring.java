/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
*/



class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 0;
        int minlen = Integer.MAX_VALUE;
        int l=0;
        int r=0;
        int start = 0;
        for(int i = 0 ; i < t.length() ; i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }

        while(r<n){
            if(map.containsKey(s.charAt(r))){
                if (map.get(s.charAt(r)) > 0) count++;
                map.put(s.charAt(r),map.get(s.charAt(r))-1); 
            }

            while(count==t.length()){
                if (r - l + 1 < minlen) {
                    minlen = r - l + 1;
                    start = l;
                }

                if (map.containsKey(s.charAt(l))) {
                    map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                    if (map.get(s.charAt(l)) > 0) count--; // break match
                }
                l++;
            }

            r++;
        }

        if(minlen==Integer.MAX_VALUE)return "";
        else return s.substring(start,start+minlen);
    }
}
