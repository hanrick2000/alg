public class Solution {
    public int uniquePaths(int m, int n) {
        // corner case
        if (m == 0 || n == 0) {
          return 0;
        }
        //state
        int[][] sum = new int[m][n]; //从起点到x,y的路径数
        //init
        for (int i = 0; i < m; i++){
          sum[i][0] = 1; //把每行第一个格子初始化成1, 1的原因是从起点到这里只有1条路径
        }
        for (int i = 0; i < n; i++){
          sum[0][i] = 1; //把每列第一个鸽子初始化成1
        }
        //fuction
        for (int i = 1; i < m; i++) { //计算从起点到x,y的路径数
            for (int j = 1; j < n; j++){
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1]; //状态转移方程
            }
        }
        //result
        return sum[m - 1][n - 1]; //返回结果
    }
}

/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
m and n will be at most 100.
input(1,3) -> 1
input(2,3) -> 3

state:      f[x][y]从起点到x,y的路径数
function:   (研究倒数第一步) f[x][y] = f[x - 1][y] + f[x][y - 1]
initialize: f[0][i] = 1
            f[i][0] = 1
answer:     f[n-1][m-1]

*/
