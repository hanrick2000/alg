/*
Given a 2D binary matrix filled with 0's and 1's, 
find the largest square containing all 1's and return its area.
For example, given the following matrix:
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
*/
/*先想想暴力方法(n^5)
for x 0->n
  for y n->m
    for a 1-> n
      for i x-a -> x
        for j y-a -> y
          update()
*/

/*
矩形, 而不是正方形
largest-rectangle-in-histogram
*/

/*follow up, 对角线
f[i][j] = min(f[i-1][j-1], left[i][j-1], up[i-1][j]) + 1
*/

public class Solution {
    public int maxSquare(int[][] matrix){
        int ans = 0;
        int n = matrix.length; //行数
        int m;
        if(n > 0) m = matrix[0].length; //列数
        else return ans;
        int[][] f = new int [n][m]; //f[i][j] 表示以i和j作为正方形右下角可以拓展的最大边长
        for(int i = 0; i < n; i++){
            f[i][0] = matrix[i][0]; //初始化第一列
            ans = Math.max(f[i][0] , ans); //为了只有一列的case, 不然有过不了的test case 比如[[1],[1]]
            for(int j = 1; j < m; j++){ //开始遍历i行的余下各列
                if(i > 0){
                    if(matrix[i][j] == 1) {
                        f[i][j] = Math.min(f[i - 1][j], Math.min(f[i][j-1], f[i-1][j-1])) + 1;
                    }else{
                        f[i][j] = 0;
                    }
                }else{
                    f[i][j] = matrix[i][j]; //初始化第一行
                }
                ans = Math.max(f[i][j], ans);
            }
        }
        return ans*ans;
    }
}

public class Solution {//滚动数组, 直接%2
    public int maxSquare(int[][] matrix) {
        int ans = 0;
        int n = matrix.length;
        int m;
        if(n > 0) m = matrix[0].length;
        else return ans;
        int [][]f = new int [2][m];
        for(int i = 0; i < n; i++){
            f[i%2][0] = matrix[i][0];
            ans = Math.max(f[i%2][0] , ans);
            for(int j = 1; j < m; j++) {
                if(i > 0) {
                    if(matrix[i][j] > 0) {
                        f[i%2][j] = Math.min(f[(i - 1)%2][j],Math.min(f[i%2][j-1], f[(i-1)%2][j-1])) + 1;
                    } else {
                        f[i%2][j] = 0;
                    }
                }
                else {
                    f[i%2][j] = matrix[i%2][j];
                }
                ans = Math.max(f[i%2][j], ans);
            }
        }
        return ans*ans;
    }
}
