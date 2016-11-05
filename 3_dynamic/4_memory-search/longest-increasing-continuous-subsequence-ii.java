public class Solution {
    int[][] f;
    int[][] flag;
    int n;
    int m;
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        if(A.length == 0) {
            return 0;
        }
        n = A.length;
        m  = A[0].length;
        int ans= 0;
        //state
        f = new int[n][m]; //f[i][j]表示在[i][j]位置能得到的LICS长度
        flag = new int[n][m];
        //search
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) { 
                f[i][j] = search(i, j, A);
                ans = Math.max(ans, f[i][j]);
            }
        }
        return ans;
    }

    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};

    int search(int x, int y, int[][] A) {
        if(flag[x][y] != 0){
            return f[x][y];
        }
        int ans = 1;  //注意这里, 最短的ans是1
        int px;
        int py; //表示上一个x y的位置
        for(int i = 0; i < 4; i++) {
            px = x + dx[i];
            py = y + dy[i];
            if(0 <= px && px < n && 0 <= py && py < m ) {
                if(A[x][y] > A[px][py]) { //当前的(x y)比上一个(x y)大, 说明可以构成递增序列
                    ans = Math.max(ans,  search(px, py, A) + 1);
                }
            }
        }
        flag[x][y] = 1;
        f[x][y] = ans;
        return ans;
    }
}

/*
Give you an integer matrix (with row size n, column size m)，
find the longest increasing continuous subsequence in this matrix. 
(The definition of the longest increasing continuous subsequence here 
can start at any row or column and go up/down/right/left any direction).
Given a matrix:
[
  [1 ,2 ,3 ,4 ,5],
  [16,17,24,23,6],
  [15,18,25,22,7],
  [14,19,20,21,8],
  [13,12,11,10,9]
]
return 25
Challenge : O(nm) time and memory.
*/

/*
follow up: 滑雪(递减子序列)
*/

