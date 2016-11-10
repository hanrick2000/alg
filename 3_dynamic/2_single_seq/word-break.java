public class Solution {
    public boolean wordBreak(String s, Set<String> dict){
        if(s == null || s.length() == 0){
            return true;
        }
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        int maxLength = 0;
        for(String word : dict){
            maxLength = Math.max(maxLength, word.length());
        }
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j <= i && j <= maxLength; j++){
                if(f[i - j] == true && dict.contains(s.substring(i - j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}





public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0){ 
            return true;
        }
        int maxLength = getMaxLength(dict);
        //state
        boolean[] f = new boolean[s.length() + 1]; //f[i]表示前i个位置(包括i), 能否被dict内的单词完美切分
        //init
        f[0] = true;
        //fuction
        for (int i = 1; i <= s.length(); i++) {//遍历输入s, O(N)
            for (int lastWordLength = 1;
                     lastWordLength <= maxLength && lastWordLength <= i;
                     lastWordLength++) { //在[i-maxLength, i]之间, 从后往前遍历每个子串, 从后往前就是一种时间优化, 只看maxLength又是一个优化, O(L)
                if (!f[i - lastWordLength]) { //以lastWordLength为切分点, 先看前半部分能不能被完美切分
                    continue;
                }
                // 比如 s="lintcode" i=8时, lastWordLength=4, s.substring(4,8) 就是 "code" 下标范围是[4,5,6,7]
                String word = s.substring(i - lastWordLength, i); //再看后半部分嫩不能被完美切分, substring返回[i-lastWordLength, i-1]闭区间内的字符串, O(L)
                if (dict.contains(word)) { //如果能被完美切分(前/后两部分), 则说明当前的i可以被完美切分, O(L)这个O(L)跟上面的是同层叠加
                    f[i] = true;
                    break; //记得退出, 优化时间
                }
            }
        }
        return f[s.length()];
    }
    private int getMaxLength(Set<String> dict) {//这个辅助函数返回dict中的最长的单词的长度, 比如是L, 可以把整体的时间复杂度优化成O(NL), N是输入字符串s的长度
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }
}

/*
Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one or more dictionary words.
Example
Given s = "lintcode", dict = ["lint", "code"].
Return true because "lintcode" can be break as "lint code".
*/
