public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //异常检测
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        //state
        int[][] paths = new int[n][m]; //默认都是0, 从起点到[i][j]的路径数
        //init
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] != 1) {//只要没有障碍, 那么到达[i][0]的路径就是1, 如果有障碍那么后续就不可能到达了
                paths[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] != 1) {//只要没有障碍, 那么到达[0][i]的路径就是1
                paths[0][i] = 1; 
            } else {
                break;
            }
        }
        //function
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] != 1) {//[i][j]位置不是障碍
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                } else {
                    paths[i][j] = 0; //如果是障碍, 那么设置成0
                }
            }
        }
        //result
        return paths[n - 1][m - 1];
    }
}

/*
Follow up for "Unique Paths":
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.
m and n will be at most 100.
There is one obstacle in the middle of a 3x3 grid as illustrated below.
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
*/
