public class Solution {
    public int[][] submatrixSum(int[][] matrix) {
        int[][] result = new int[2][2];
        int M = matrix.length;
        if (M == 0) return result; //M行
        int N = matrix[0].length;
        if (N == 0) return result; //N列
        int[][] sum = new int[M + 1][N + 1];
        for (int j = 0; j <= N; ++j) sum[0][j] = 0;
        for (int i = 1; i <= M; ++i) sum[i][0] = 0;
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                sum[i + 1][j + 1] = matrix[i][j] + sum[i + 1][j] + sum[i][j + 1] - sum[i][j];
            }
        }
        for (int l = 0; l < M; ++l) {
            for (int h = l + 1; h <= M; ++h) {
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                for (int j = 0; j <= N; ++j) {
                    int diff = sum[h][j] - sum[l][j];
                    if (map.containsKey(diff)) {
                        int k = map.get(diff);
                        result[0][0] = (l - 1) + 1;//减一是为了把坐标变成以0为开头的
                        result[0][1] = (k - 1) + 1;//后面加一是因为记录的下一个位置才是和为0的开头
                        result[1][0] = h - 1; 
                        result[1][1] = j - 1;
                        return result;
                    } else {
                        map.put(diff, j); //记录的是列的位置
                    }
                }
            }
        }
        return result;
    }
}

/*
这道题和求数组中哪些元素和为0的解决方法一样,
只是数组中求的是前i个元素和前j个元素和相等, 则i－j元素和为0, 而这里只是变成2维的而已.

sum[i][j]表示matrix[0][0]到matrix[i-1][j-1]作为左上右下点构成的矩阵的所有元素的和.
建立sum矩阵, 为n + 1行，m + 1列. 将第0行和第0列都初始化为0.
遍历matrix，根据公式 
sum[i][j] = matrix[i - 1][j - 1] + sum[i][j - 1] + sum[i - 1][j] -sum[i - 1][j - 1] 
计算所有sum.
然后取两个row: l1, l2.
用一个线k从左到右扫过l1和l2, 
每次都用diff = sum[l1][k] - sum[l2][k] 来表示纵长(l1到l2)和横长(0到k)这个矩形元素的sum.
如果在同一个l1和l2中, 有两条线(k1, k2)的diff相等,
则表示l1 - l2和k1 - k2这个矩形中的元素和为0.

Given an integer matrix, find a submatrix where the sum of numbers is zero. 
Your code should return the coordinate of the left-up and right-down number.
Example
Given matrix
[
  [1 , 5 , 7],
  [3 , 7 ,-8],
  [4 ,-8 , 9],
]
return [(1,1), (2,2)]
Challenge 
O(n3) time.
Tags: Enumeration, Matrix
*/
