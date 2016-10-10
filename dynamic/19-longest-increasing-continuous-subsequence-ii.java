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

public class Solution {
    int [][]dp;
    int [][]flag ;
    int n ,m;
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        if(A.length == 0) return 0;
        n = A.length;
        m  = A[0].length;
        int ans= 0;
        dp = new int[n][m]; //走到当前x,y位置, 能得到的LICS长度
        flag = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) { 
                dp[i][j] = search(i, j, A);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    int search(int x, int y, int[][] A)   {
        if(flag[x][y] != 0)    
            return dp[x][y];
        int ans = 1;  //注意这里, 最短的ans是1
        int nx , ny;
        for(int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if(0<= nx && nx < n && 0<= ny && ny < m ) {
                if( A[x][y] > A[nx][ny]) {
                    ans = Math.max(ans,  search( nx, ny, A) + 1);
                }
            }
        }
        flag[x][y] = 1;
        dp[x][y] = ans;
        return ans;
    }
}
