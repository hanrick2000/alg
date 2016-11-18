public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length; //有m行
        int n = m > 0 ? grid[0].length : 0; //有n列
        int result = 0;
        int rows = 0;
        int[] cols = new int[n];
        for (int i = 0; i < m; ++i) { //i行
            for (int j = 0; j < n; ++j) { //j列
                if (grid[i][j] == '0'){
                    if (j == 0 || grid[i][j-1] == 'W') {
                        rows = 0;
                        for (int k = j; k < n && grid[i][k] != 'W'; ++k){
                            if (grid[i][k] == 'E'){
                                rows += 1;
                            }
                        }
                    }
                    if (i == 0 || grid[i-1][j] == 'W') {
                        cols[j] = 0;
                        for (int k = i; k < m && grid[k][j] != 'W'; ++k){
                            if (grid[k][j] == 'E'){
                                cols[j] += 1;
                            }
                        }
                    }
                    if (rows + cols[j] > result){
                        result = rows + cols[j];
                    }
                }
            }
        }
        return result;
    }
}
public class Solution {
    /**
     * @param grid Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        // Write your code here
        int m = grid.length; //有m行
        int n = m > 0 ? grid[0].length : 0; //有n列

        int result = 0;
        int rows = 0;
        int[] cols = new int[n];
        for (int i = 0; i < m; ++i) { //i行
            for (int j = 0; j < n; ++j) { //j列
                if (j == 0 || grid[i][j-1] == 'W') {
                    rows = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; ++k){
                        if (grid[i][k] == 'E'){
                            rows += 1;
                        }
                    }
                }
                if (i == 0 || grid[i-1][j] == 'W') {
                    cols[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; ++k){
                        if (grid[k][j] == 'E'){
                            cols[j] += 1;
                        }
                    }
                }
                if (grid[i][j] == '0' && rows + cols[j] > result){
                    result = rows + cols[j];
                }
            }
        }
        return result;
    }
}

/*
Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
You can only put the bomb at an empty cell.
Example
Given a grid:
0 E 0 0
E 0 W E
0 E 0 0
return 3. (Placing a bomb at (1,1) kills 3 enemies)
Tags 
Dynamic Programming, Google

这道题的思想就是遍历数组中的每一个点，
当前点能够得到的最大值为从左边的头到右边的头的值（row值）＋
从上面的头到下面的头的值（col值）。
每一个row范围内的点都共用当前的row值，每一个col范围内的点都共用当前col值。
当从新的边界或者wall开始时，相当于进入了新的一段范围，要重新计算row值或者col值。

遍历数组中每一个点，若为0则开始计算
2 若当前点为第一列或者左边一个点为wall，表明进入了一个新的区间，需要重新计算。
  从该点开始一直向右直到遇到边界或者wall，在该过程中，每遇到一个E就将row值＋1
3 若当前点为第一行或者上边一个点为wall，表明进入了一个新的区间，需要重新计算。
  从该点开始一直向下直到遇到边界或者wall，在该过程中，每遇到一个E就将col值＋1
重复2-3步骤
*/
