public class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        //state
        int[][] f = new int[n + 1][m + 1]; //f[i][j]表示A的前i个字符最少要用几次编辑变成B的前j个字符
        //init
        for(int i = 0; i < m + 1; i++){ 
            f[0][i] = i; //把一个空串变成i长度的, 需要i次编辑
        }
        for(int i = 0; i < n + 1; i++){
            f[i][0] = i;
        }
        //function
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i -  1) == word2.charAt(j - 1)){
                    f[i][j] = f[i - 1][j - 1]; //相等
                }else{
                    f[i][j] = 1 + Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])); //不等, 从三者里面选出最小的, 然后加1
                                           //replace        del                   insert
                }
            }
        }
        //result
        return f[n][m];
    }
}
/*
当A的第i个字母和B的第j个字母不等时
Insert a character, 在A的最后增加一个字母, 使之跟B的第j个字母相同, 这样当前的编辑距离取决于i, j-1
Delete a character  把A的最后一个与B最后字母不同的字母删掉, 这样当前的编辑距离取决于i-1, j
Replace a character 把A的最后一个不同字母换成B的最后一个字母, 这样A和B的最后字母都相同了, 当前的编辑距离取决于i-1, j-1位置
*/

/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
You have the following 3 operations permitted on a word:
Insert a character,
Delete a character
Replace a character
Given word1 = "mart" and word2 = "karma", return 3.
*/
