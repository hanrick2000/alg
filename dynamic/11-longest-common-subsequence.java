/*
Given two strings, find the longest common subsequence (LCS). 最长公共子序列, 不一定连续
Your code should return the length of LCS.
Clarification
What's the definition of Longest Common Subsequence?
https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
http://baike.baidu.com/view/2020307.htm
Example
For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.
For "ABCD" and "EACB", the LCS is "AC", return 2.
*/
public class Solution {
    public int longestCommonSubsequence(String A, String B) {
        int n = A.length();
        int m = B.length();
        int f[][] = new int[n + 1][m + 1]; //f[i][j] A的前i个字符和B的前j个字符的LCS是多长
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(A.charAt(i - 1) != B.charAt(j -1)){ //A子串的最后一个字母和B子串的最后一个字母比较
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]); //最后一个字符不等, 看[i][j]的左边[i-][j]和上边[i][j-1]
                }else{
                    f[i][j] = f[i - 1][j - 1] + 1; //最后一个字符相等
                }
            }
        }
        return f[n][m];
    }
}
/*
state: f[i][j] A的前i个字符和B的前j个字符的LCS是多长
1. A[i-1] == B[j-1] 
   f[i][j] = MAX{
             f[i-1][j-1] + 1 //让i-1和j-1在LCS里
             f[i-1][j]       //让i-1不在LCS里
             f[i][j-1]       //让j-1不在LCS里
             }
2. A[i-1] != B[j-1] 
   f[i][j] = MAX{
             f[i-1][j]       //让i-1不在LCS里
             f[i][j-1]       //让j-1不在LCS里
             f[i-1][j-1]     //都不在LCS里
             }
求最长公共子序列的数目，注意这里的子序列可以不是连续序列，务必问清楚题意。
求『最长』类的题目往往与动态规划有点关系，这里是两个字符串，故应为双序列动态规划。
这道题的状态很容易找，不妨先试试以f[i][j]表示字符串 A 的前 i 位和字符串 B 的前 j 位的最长公共子序列数目，
那么接下来试试寻找其状态转移方程。
从实际例子ABCD和EDCA出发，首先初始化f的长度为字符串长度加1，那么有f[0][0] = 0, f[0][*] = 0, f[*][0] = 0, 
最后应该返回f[lenA][lenB]. 
即 f 中索引与字符串索引对应(字符串索引从1开始算起)，那么在A 的第一个字符与 B 的第一个字符相等时，
f[1][1] = 1 + f[0][0], 否则f[1][1] = max(f[0][1], f[1][0])。
推而广之，也就意味着若A[i] == B[j], 则分别去掉这两个字符后，原 LCS 数目减一，
那为什么一定是减1而不是0或者2呢？
因为不管公共子序列是以哪个字符结尾，在A[i] == B[j]时 LCS 最多只能增加1. 
而在A[i] != B[j]时，由于A[i] 或者 B[j] 不可能同时出现在最终的 LCS 中，
故这个问题可进一步缩小，f[i][j] = max(f[i - 1][j], f[i][j - 1]). 
需要注意的是这种状态转移方程只依赖最终的 LCS 数目，而不依赖于公共子序列到底是以第几个索引结束。

模拟过程: 这个图实际是行列反了, 看下面的吧
A="abcd", B="abec", 若A[i-1] == B[j-1], 则用左斜上角的数+1作为LCS, 若不等, 则从上面或者左边取最大的作为LCS
          0      1       2       3        4    i  
          ^      a       ab      abc      abcd
0  ^      0      0       0       0        0
1  a      0      1  <-   1   <-  1        1 
2  ab     0      1       2   <-  2        2
3  abe    0      1       2       2        2
4  abec   0      1       2       3        3
j
*/

A="abcd" B="abe"
           j=0 j=1 j=2 j=3
           ^   a   ab  abe
i=0  ^     0   0   0   0
i=1  a     0   1   1   1
i=2  ab    0            
i=3  abc   0            
i-4  abcd  0            

A="abcd" B="abe"
           j=0 j=1 j=2 j=3
           ^   a   ab  abe
i=0  ^     0   0   0   0
i=1  a     0   1   1   1
i=2  ab    0   1   2   2            
i=3  abc   0            
i-4  abcd  0            

A="abcd" B="abe"
           j=0 j=1 j=2 j=3
           ^   a   ab  abe
i=0  ^     0   0   0   0
i=1  a     0   1   1   1
i=2  ab    0   1   2   2            
i=3  abc   0   1   2   2         
i-4  abcd  0            

A="abcd" B="abe"
           j=0 j=1 j=2 j=3
           ^   a   ab  abe
i=0  ^     0   0   0   0
i=1  a     0   1   1   1
i=2  ab    0   1   2   2
i=3  abc   0   1   2   2
i-4  abcd  0   1   2   2

