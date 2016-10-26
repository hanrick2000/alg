public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int i = 0; 
        int j = 0;
        char c;
        int n = s.length();
        for (i = 0; i < n; i++) {
            while (j < n) {
                c = s.charAt(j);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    if(map.size() == k){
                        break; //到了限定条件, 不同字符种类达到了k
                    }
                    map.put(c, 1);
                }
                j++;
            }
            maxLen = Math.max(maxLen, j - i);
            c = s.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                if (count > 1) {
                    map.put(c, count - 1);
                } else {
                    map.remove(c);
                }
            }
        }
        return maxLen; 
    }
}

/*
Given a string s, find the length of the longest substring T that contains at most k distinct characters.
Example
For example, Given s = "eceba", k = 3,
T is "eceb" which its length is 4.
Challenge 
O(n), n is the size of the string s.
*/
