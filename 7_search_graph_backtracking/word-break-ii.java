public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> list = new ArrayList<String>();
        List<String> ret = new ArrayList<String>();
        dfs(s, wordDict, list, ret);
        return ret;
    }
    public void dfs(String s, Set<String> dict, List<String> list, List<String> ret){
        if(!isBreak(s, dict)){
            return;
        }
        if(s.length() == 0){
            String concat = "";
            for(int i = 0; i < list.size(); i++){
                concat += list.get(i);
                if(i != list.size() - 1){
                    concat += " ";
                }
            }
            ret.add(concat);
            return;
        }
        for(String cur : dict){
            if(s.length() < cur.length()){
                continue;
            }
            String substr = s.substring(0, cur.length());
            if(substr.equals(cur){ //当从当前s截取的前n个字符等于字典中的单词, 那么放入临时结果中
                list.add(substr);
                dfs(s.substring(cur.length()), dict, list, ret);
                list.remove(list.size() - 1);
            }
        }
    }
    public boolean isBreak(String s, Set<String> dict){
        if(s == null || s.length() == 0){
            return true;
        }
        boolean[] f = new boolean[s.length() + 1];
        int maxLength = 0;
        for(String word: dict){
            maxLength = Math.max(maxLength, word.length());
        }
        f[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j <= i && j<= maxLength; j++){
                if(f[i - j] == true && dict.contains(s.substring(i - j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}




/*
Given a string S and a dictionary of words dict, 
add spaces in S to construct a sentence where each word is a valid dictionary word.
Return all such possible sentences.
Example
Gieve s = lintcode,
dict = ["de", "ding", "co", "code", "lint"].
A solution is ["lint code", "lint co de"].
Tags 
Backtracking Dynamic Programming
*/

/*
这道题类似  Word Break 判断是否能把字符串拆分为字典里的单词 @LeetCode 
只不过要求计算的并不仅仅是是否能拆分，而是要求出所有的拆分方案。
因此用递归。
但是直接递归做会超时，原因是LeetCode里有几个很长但是无法拆分的情况，
所以就先跑一遍Word Break，先判断能否拆分，然后再进行拆分。
递归思路就是，逐一尝试字典里的每一个单词，看看哪一个单词和S的开头部分匹配，如果匹配则递归处理S的除了开头部分，直到S为空，说明可以匹配。
*/


