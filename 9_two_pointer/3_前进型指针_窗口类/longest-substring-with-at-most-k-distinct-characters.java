public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int j = 0;
        char c;
        for (int i = 0; i < s.length(); i++) { 
            while (j < s.length()) { 
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
//外层遍历i从0到n-1, 内层while遍历j小于n, 如果map中有j位置字符, 那么增加其计数, 如果没有, 首先判断map的大小是否到达上限, 不达上限可以把当前j位置字符加入, j向前移动
//当达到上限时, 退出当前的while循环, 更新答案maxLen, 把i位置的字符删掉或者减少计数

/*
Given a string s, find the length of the longest substring T that contains at most k distinct characters.
Example
For example, Given s = "eceba", k = 3,
T is "eceb" which its length is 4.
Challenge 
O(n), n is the size of the string s.
*/
