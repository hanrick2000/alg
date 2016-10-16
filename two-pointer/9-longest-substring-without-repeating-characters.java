/*
Given a string, find the length of the longest substring without repeating characters.
Example
For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
For "bbbbb" the longest substring is "b", with the length of 1.
Challenge 
O(n) time
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256]; // map from character's ASCII to its last occured index
        Arrays.fill(map, -1);
        int slow = 0;
        int fast = 0;
        int ans = 0;
        for (fast = 0; fast < s.length(); fast++) {
            int ch = s.charAt(fast);
            while (map[ch]!=-1 && slow < fast) {
                int temp = s.charAt(slow);
                map[temp] = -1;
                slow ++;
            }
            map[ch] = 0;
            ans = Math.max(ans, fast-slow + 1);
        }
        return ans;
    }
}

/*
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashSet<Character> set = new HashSet<Character>();
        int leftBound = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                while (leftBound < i && s.charAt(leftBound) != s.charAt(i)) {
                    set.remove(s.charAt(leftBound));
                    leftBound ++;
                }
                leftBound ++;
            } else {
                set.add(s.charAt(i));
                max = Math.max(max, i - leftBound + 1);
            }
        }
        return max;
    }
}
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256]; // map from character's ASCII to its last occured index
        int ans = 0;
        int slow = 0;
        Arrays.fill(map, -1);
        for (int fast = 0; fast < s.length(); fast++) {
            int ch = s.charAt(fast);
            if (map[ch] >= slow) {
                ans = Math.max(ans, fast - slow);
                slow = map[ch] + 1;
            }
            map[ch] = fast;
        }
        return Math.max(ans, s.length() - slow);
    }
}
