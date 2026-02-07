/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i <= s.length()-p.length() ; i++){
            String s1 = s.substring(i,i+p.length());
            if(isAnagram(s1,p))list.add(i);
        }
        
        return list;
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] arr = new int[26];

        Arrays.fill(arr,0);
        for(int i = 0 ; i < s.length() ; i++){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != 0)return false;
        }
        return true;
    }
}
