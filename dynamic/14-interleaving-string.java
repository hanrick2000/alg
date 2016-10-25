public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        //state
        boolean [][] f = new boolean[s1.length() + 1][s2.length() + 1]; //f[i][j]表示s1的前i个字符和s2的前j个字符能否交替组成s3的前i+j个字符
        //init
        f[0][0] = true;
        for (int i = 1; i <= s1.length(); i++){
            if(s3.charAt(i - 1) == s1.charAt(i - 1) && f[i - 1][0]){
                f[i][0] = true;
            }
        }
        for (int j = 1; j <= s2.length(); j++){
            if(s3.charAt(j - 1) == s2.charAt(j - 1) && f[0][j - 1]){
                f[0][j] = true;
            }
        }
        //function
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) { //s1的前i个字符和s2的前j个字符能够组成s3的前i+j字符的条件: 
                if(((s3.charAt(i + j - 1) == s1.charAt(i - 1) && f[i - 1][j])) //s1子串的最后一个字符和s3子串的最后一个字符相等, 那么问题转化为f[i-1][j]是否可行
                 || (s3.charAt(i + j - 1) == s2.charAt(j - 1) && f[i][j - 1])) //s2子串的最后一个字符和s3子串的最后一个字符相等, 问题转化为f[i][j-1]是否可行
                f[i][j] = true;
            }
        }
        //result
        return f[s1.length()][s2.length()];
    }
}

//有模拟过程

/*
Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.
For s1 = "aabcc", s2 = "dbbca"
When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
S3能不能用S1和S2交替的组成
*/
