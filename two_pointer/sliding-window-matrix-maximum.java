public class Solution {
    public int maxSlidingWindow2(int[][] matrix, int k) {
        int n = matrix.length;
        if (n == 0 || n < k){
            return 0;
        }
        int m = matrix[0].length;
        if (m == 0 || m < k){
            return 0;
        }
        int[][] sum = new int[n + 1][m + 1]; //表示0到i-1行和0到j-1列所有元素的和
        for (int i = 0; i <= n; ++i) {
            sum[i][0] = 0;
        }
        for (int i = 0; i <= m; ++i) {
            sum[0][i] = 0;
        }
        for (int i = 1; i <= n; ++i){
            for (int j = 1; j <= m; ++j){
                sum[i][j] = matrix[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }
        int max_value = Integer.MIN_VALUE;
        for (int i = k; i <= n; ++i)
            for (int j = k; j <= m; ++j) {
                int value = sum[i][j] - sum[i - k][j] - sum[i][j - k] + sum[i - k][j - k];
                //即整个大窗口减去上面一部分和左边一部分再加回被重复减去的部分，即为当前窗口值
                if (value > max_value) {
                    max_value = value;
                }
            }
        }
        return max_value;
    }
}

Given an array of n * m matrix, 
and a moving matrix window (size k * k), 
move the window from top left to botton right at each iteration, 
find the maximum number inside the window at each moving.
Return 0 if the answer does not exist.
Example
For matrix
[
  [1, 5, 3],
  [3, 2, 1],
  [4, 1, 9],
]
The moving window size k = 2. 
return 13.

At first the window is at the start of the array like this

[
  [|1, 5|, 3],
  [|3, 2|, 1],
  [4, 1, 9],
]
,get the sum 11;
then the window move one step forward.

[
  [1, |5, 3|],
  [3, |2, 1|],
  [4, 1, 9],
]
,get the sum 11;
then the window move one step forward again.

[
  [1, 5, 3],
  [|3, 2|, 1],
  [|4, 1|, 9],
]
,get the sum 10;
then the window move one step forward again.

[
  [1, 5, 3],
  [3, |2, 1|],
  [4, |1, 9|],
]
,get the sum 13;
SO finally, get the maximum from all the sum which is 13.

Challenge 
O(n^2) time.
