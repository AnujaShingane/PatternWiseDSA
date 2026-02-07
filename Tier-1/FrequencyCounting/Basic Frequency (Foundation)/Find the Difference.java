/*
Example 1:

Input: s = "abcd", t = "abcde"
Output: "e"
Explanation: 'e' is the letter that was added.
Example 2:

Input: s = "", t = "y"
Output: "y"
*/


class Solution {
    public char findTheDifference(String s, String t) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(char ch : t.toCharArray()){
            if(!map.containsKey(ch)){
                return ch;
            }
            map.put(ch,map.get(ch)-1);
            if(map.get(ch)==0)map.remove(ch);
        }

        return ' ';
    }
}
