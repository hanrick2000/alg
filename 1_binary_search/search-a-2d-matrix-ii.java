public class Solution {
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length; 
        int m = matrix[0].length; 
        int x = n - 1; 
        int y = 0; //从左下角开始, 是因为可以根据大于或者小于target做划分, 左上角就不行, 比如小于target, 不知道是往下走还是往右走
        int count = 0;
        while (x >= 0 && y < m) {
            if (matrix[x][y] < target) {
                //如果A[x][y]小于target,则A[x][y]应该向右侧移动, 因为每一行都是有序的
                y++;
            } else if (matrix[x][y] > target) {
                //如果A[x][y]大于target,则A[x][y]应该向上移动, 因为每一列也是有序的
                x--;
            } else if (matrix[x][y] == target) {
                //如果相等了,则本行和本列都不会有相同的了
                count++;
                x--;
                y++;
            }
        }
        return count;
    }
}

/*
Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.
This matrix has the following properties:
Integers in each row are sorted from left to right.
Integers in each column are sorted from up to bottom.
No duplicate integers in each row or column.
[
  [1, 3, 5, 7],
  [2, 4, 7, 8],
  [3, 5, 9, 10]
]
Given target = 3, return 2.
*/
