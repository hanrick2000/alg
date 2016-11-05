public class Solution {
    public int longestCommonSubstring(String A, String B) {
        int n = A.length();
        int m = B.length();
        // state
        int[][] f = new int[n + 1][m + 1]; //A的前i个字符(以i为结尾)和B的前j个字符(以j为结尾)的LCS长度
        int max = 0;
        // fuction
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                    if( f[i][j] > max) {
                        max = f[i][j];
                    }
                } else {
                    f[i][j] = 0;
                }
            }
        }
        return max;
    }
}


Given two strings, find the longest common substring.
Return the length of it.
The characters in substring should occur continuously in original string. This is different with subsequence.
Example
Given A = "ABCD", B = "CBCE", return 2.
Challenge 
O(n x m) time and memory.

// 严格的说，这个算法是递推，而不是动态规划，但是可以用动态规划的四要素去分析换个解答。
// 为什么不是动态规划？因为最暴力的方式也就是 O(n^3) 可以找到A所有的Substring然后看看在不在B里。
