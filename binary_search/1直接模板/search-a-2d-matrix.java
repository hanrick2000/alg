public class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0){
      return false;
    }
    if (matrix[0] == null || matrix[0].length == 0) {
      return false;
    }
    int row = matrix.length;
    int column = matrix[0].length;
    int start = 0;
    int end = row * column - 1; //变成一维的
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      int number = matrix[mid / column][mid % column]; //行列值通过end计算得到
      if (number == target) {
        return true;
      } else if (number < target) {
        start = mid;
      } else if (number > target) {
        end = mid;
      }
    }
    if (matrix[start / column][start % column] == target) {
      return true;
    } else if (matrix[end / column][end % column] == target) {
      return true;
    }
    return false;
  }
}

/*
要点是把矩阵看成是一维的，然后根据数学计算来得到行列
当成一维的index
行 index / column
列 index % column
Write an efficient algorithm that searches for a value in an m x n matrix.
This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Consider the following matrix:
[
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
]
Given target = 3, return true.
*/
