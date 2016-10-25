public class Solution {
    public int numDistinct(String S, String T) {
        if (S == null || T == null){
            return 0;
        }
        //state
        int[][] nums = new int[S.length() + 1][T.length() + 1]; //nums[i][j]表示S的前i个字符中选取T的前j个字符, 有多少中挑选方案
        //init
        for (int i = 0; i <= S.length(); i++) {
            nums[i][0] = 1; //从字符串中挑出空串, 总会是有1个方案
        }
        //function
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    nums[i][j] = nums[i - 1][j] + nums[i - 1][j - 1]; //最后一个字符相等: 不配对最后一个字母 + 配对最后一个字母
                }else{
                    nums[i][j] = nums[i - 1][j]; //最后一个字符不等: 转化成S的前i-1个字符中选取T的前j个字符的挑选方案数
                }
            }
        }
        //result
        return nums[S.length()][T.length()];
    }
}

//有模拟图, 手机备忘录中

/*
Given a string S and a string T, count the number of distinct subsequences of T in S.
A subsequence of a string is a new string which is formed from the original string 
by deleting some (can be none) of the characters 
without disturbing the relative positions of the remaining characters. 
(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Given S = "rabbbit", T = "rabbit", return 3.
定义f[i][j]为 S[0:i] 中子序列为 T[0:j] 的个数，
接下来寻找状态转移关系，状态转移应从 f[i-1][j], f[i-1][j-1], f[i][j-1] 中寻找，
接着寻找突破口——S[i] 和 T[j] 的关系。
S[i] == T[j]: 两个字符串的最后一个字符相等，
  我们可以选择 S[i] 和 T[j] 配对，那么此时有 f[i-1][j-1] 种可行方案 
  若不使 S[i] 和 T[j] 配对，而是选择 S[0:i-1] 中的某个字符和 T[j] 配对，此时有f[i-1][j]种可行方案
  综合以上两种选择，可得知在S[i] == T[j]时有 f[i][j] = f[i-1][j-1] + f[i-1][j]
S[i] != T[j]: 最后一个字符不等时，S[i] 不可能和 T[j] 配对，故 f[i][j] = f[i-1][j]
*/
