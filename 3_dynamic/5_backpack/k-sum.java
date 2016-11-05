//n个数, 取k个数, 组成和为target
public class Solution {
    public int  kSum(int A[], int k, int target) {
        int n = A.length;
        // state
        int[][][] f = new int[n + 1][k + 1][target + 1]; //f[i][j][t]前i个数, 取j个数, 和为t的方案数
        // init
        for (int i = 0; i < n + 1; i++) {
            f[i][0][0] = 1;
        }
        // function
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                for (int t = 1; t <= target; t++) {
                    f[i][j][t] = f[i - 1][j][t]; //不取第i个元素
                    if (t >= A[i - 1]) { //能取第i个元素
                        f[i][j][t] = f[i - 1][j][t] + f[i - 1][j - 1][t - A[i - 1]];
                    }
                }
            }
        }
        // result
        return f[n][k][target];
    }
}

/*
Given n distinct positive integers, integer k (k <= n) and a number target.
Find k numbers where sum is target. Calculate how many solutions there are?
Example
Given [1,2,3,4], k = 2, target = 5.
There are 2 solutions: [1,4] and [2,3].
Return 2.
*/
