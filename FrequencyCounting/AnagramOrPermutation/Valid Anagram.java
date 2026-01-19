/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false
*/



class Solution {
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
